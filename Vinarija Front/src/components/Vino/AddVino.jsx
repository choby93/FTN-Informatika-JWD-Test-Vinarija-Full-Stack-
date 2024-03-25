import React, { useCallback, useEffect, useState } from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import Axios from "../../apis/Axios";
import { useNavigate } from "react-router-dom";

const AddVino = () => {
  const [tipVina, setTipVina] = useState([]);
  const [vinarija, setVinarija] = useState([]);
  const navigate = useNavigate();
  const [validno, setValidno] = useState(false);
  const [novoVino, setNovoVino] = useState({
    ime: "",
    opis: "",
    godinaProizvodnje: "",
    cenaFlase: "",
    tipVinaId: "",
    vinarijaId: "",
  });

  useEffect(() => {
    getVina();
    getVnarije();
  }, []);

  //preuzimanje tipova vina
  const getVina = useCallback(() => {
    Axios.get("/tipovi")
      .then((result) => {
        console.log(result);
        setTipVina(result.data);
      })
      .catch((error) => {
        console.log(error);
        alert("Došlo je do greške u preuzimanju tipova vina!");
      });
  }, []);

  //preuzimanje vinarija
  const getVnarije = useCallback(() => {
    Axios.get("/vinarije")
      .then((result) => {
        console.log(result);
        setVinarija(result.data);
      })
      .catch((error) => {
        console.log(error);
        alert("Došlo je do greške u preuzimanju vinarija!");
      });
  }, []);

  //dodavanje vina
  const addVino = () => {
    let params = {
      ime: novoVino.ime,
      opis: novoVino.opis,
      godinaProizvodnje: novoVino.godinaProizvodnje,
      cenaFlase: novoVino.cenaFlase,
      tipVinaId: novoVino.tipVinaId,
      vinarijaId: novoVino.vinarijaId,
    };

    Axios.post("/vina", params)
      .then((result) => {
        console.log(result);
        navigate("/vina");
      })
      .catch((error) => {
        console.log(error);
        alert("Došlo je do greške prilikom dodavanja vina!");
      });
  };

  //select tip vina
  const tipSelect = () => {
    return tipVina.map((t) => {
      return (
        <option value={t.id} key={t.id}>
          {t.ime}
        </option>
      );
    });
  };

  //select vinarija
  const vinarijaSelect = () => {
    return vinarija.map((v) => {
      return (
        <option value={v.id} key={v.id}>
          {v.ime}
        </option>
      );
    });
  };

  const validacija = () => {
    if (
      novoVino.ime == "" ||
      novoVino.opis == "" ||
      novoVino.godinaProizvodnje == "" ||
      novoVino.cenaFlase == "" ||
      novoVino.tipVinaId == "" ||
      novoVino.vinarijaId == ""
    ) {
      setValidno(false);
    } else {
      setValidno(true);
    }
  };

  const onInputValue = (e) => {
    const name = e.target.name;
    const value = e.target.value;

    const novo = novoVino;
    novo[name] = value;
    setNovoVino(novo);
    validacija();
  };

  return (
    <Row>
      <Col>
        <Form className="d-grid gap-3">
          <Form.Group>
            <Form.Label>
              <strong>Naziv vina </strong>{" "}
            </Form.Label>
            <Form.Control
              placeholder="Naziv vina"
              name="ime"
              type="text"
              onChange={(e) => onInputValue(e)}
            ></Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>
              <strong>Opis vina</strong>
            </Form.Label>
            <Form.Control
              placeholder="Opis vina"
              as="textarea"
              rows={5}
              name="opis"
              onChange={(e) => onInputValue(e)}
            ></Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>
              <strong>Godina proizvodnje</strong>
            </Form.Label>
            <Form.Control
              placeholder="Godina proizvodje"
              name="godinaProizvodnje"
              type="text"
              onChange={(e) => onInputValue(e)}
            ></Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>
              <strong>Cena po flaši</strong>
            </Form.Label>
            <Form.Control
              placeholder="Cena po flaši"
              name="cenaFlase"
              type="text"
              onChange={(e) => onInputValue(e)}
            ></Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>
              <strong>Tip vina</strong>
            </Form.Label>
            <Form.Select
              placeholder="Izaberi tip vina"
              name="tipVinaId"
              onChange={(e) => onInputValue(e)}
            >
              <option value={-1}>Izaberi tip vina</option>
              {tipSelect()}
            </Form.Select>
          </Form.Group>
          <Form.Group>
            <Form.Label>
              <strong>Vinarija</strong>
            </Form.Label>
            <Form.Select
              placeholder="Izaberi tip vina"
              name="vinarijaId"
              onChange={(e) => onInputValue(e)}
            >
              <option value={-1}>Izaberi vinariju</option>
              {vinarijaSelect()}
            </Form.Select>
          </Form.Group>
        </Form>
        <Button className="mt-3" onClick={addVino} disabled={!validno}>
          Kreiraj vino
        </Button>
      </Col>
    </Row>
  );
};

export default AddVino;
