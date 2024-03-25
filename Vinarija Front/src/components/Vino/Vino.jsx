import React, { useCallback, useEffect, useState } from "react";
import { Button, Col, Form, Row, Table } from "react-bootstrap";
import Axios from "../../apis/Axios";
import VinoRow from "./VinoRow";
import { useNavigate } from "react-router-dom";

const Vino = () => {
  const admin = window.localStorage["role"] === "ROLE_ADMIN";
  const user = window.localStorage["role"] === "ROLE_KORISNIK";
  const [vino, setVino] = useState([]);
  const [vinarija, setVinarija] = useState([]);
  const [pageNo, setPageNo] = useState(0);
  const [totalPage, setTotalPage] = useState(0);
  const [pretraga, setPretraga] = useState({
    vinarijaId: "",
    nazivVina: "",
  });
  const navigate = useNavigate();

  //preuzimanje vina paginarno
  const getVino = useCallback((nextPage) => {
    const config = {
      params: {
        ime: pretraga.nazivVina,
        vinarijaId: pretraga.vinarijaId,
        pageNo: nextPage,
      },
    };

    Axios.get("/vina", config)
      .then((result) => {
        setVino(result.data);
        console.log(result);
        setPageNo(nextPage);
        setTotalPage(result.headers["total-pages"]);
      })
      .catch((error) => {
        console.log(error);
        alert("Došlo je do greške u preuzimanju vina!");
      });
  }, []);

  //preuzimanje vinarija
  const getVinarija = useCallback(() => {

    Axios.get("/vinarije")
      .then((result) => {
        setVinarija(result.data);
        console.log(result);
      })
      .catch((error) => {
        console.log(error);
        alert("Došlo je do greše u preutimanju vinarija");
      });
  }, []);

  useEffect(() => {
    getVino(0);
    getVinarija();
  }, []);

  //render VinoRow
  const renderVinoRow = () => {
    return vino.map((vino, index) => {
        return <VinoRow key={vino.id} vino={vino} />;
    });
  };

  // select vinarija
  const selectVinarija = () => {
    return vinarija.map((v) => {
      return (
        <option key={v.id} value={v.id}>
          {v.ime}
        </option>
      );
    });
  };

  //pretraga
  const pretragaVinarajia = (e) => {
    let name = e.target.name;
    let value = e.target.value;

    let novaPretraga = pretraga;
    novaPretraga[name] = value;
    setPretraga(novaPretraga);
  };

  const doSearch = () => {
    getVino(0);
  };

  const doRefresh = () => {
    window.location.reload();
  };

  const goToAdd = () => {
    navigate("/vina/add");
  };

  return (
    <Row>
      <Row>
        <Row>
          <Col className="d-flex justify-content-center">
            <h1>Vinarija</h1>
          </Col>
        </Row>
        <Col>
          <Form className="d-grid gap-3">
            <Form.Group>
              <Form.Label>Vinarija</Form.Label>
              <Form.Select
                name="vinarijaId"
                onChange={(e) => pretragaVinarajia(e)}
              >
                <option value={""}></option>
                {selectVinarija()}
              </Form.Select>
            </Form.Group>
            <Form.Group>
              <Form.Label>Naziv vina</Form.Label>
              <Form.Control
                onChange={(e) => pretragaVinarajia(e)}
                type="text"
                name="nazivVina"
              ></Form.Control>
            </Form.Group>
          </Form>
          <Col className="d-flex gap-2 mt-3">
            <Button onClick={(e) => doSearch(e)}>Pretraga</Button>
            <Button variant="warning" onClick={(e) => doRefresh(e)}>
              Osveži
            </Button>
          </Col>
        </Col>
      </Row>

      <Row style={{ paddingTop: "25px" }}>
        <Col>
          {admin ? (
            <Button variant="success" onClick={(e) => goToAdd(e)}>
              Kreiraj
            </Button>
          ) : null}
        </Col>
        <Col style={{ display: "flex", justifyContent: "end" }}>
          <Button disabled={pageNo === 0} onClick={() => getVino(pageNo - 1)}>
            Predhodna
          </Button>
          <Button
            disabled={pageNo + 1 === totalPage || vino.length === 0}
            onClick={() => getVino(pageNo + 1)}
          >
            Sledeća
          </Button>
        </Col>
      </Row>
      <Col>
        <Table bordered striped style={{ marginTop: 5 }}>
          <thead>
            <tr>
              <th>Naziv vina</th>
              <th>Vinarija</th>
              <th>Tip</th>
              {user ? (
                <th>Opis</th>
              ) : null}
              <th>Godina proizvodnje</th>
              <th>Cena po flaši(rsd)</th>
              {admin ? (
                <th>Broj preostalih flaša</th>
              ) : null}
              <th></th>
            </tr>
          </thead>
          <tbody>{renderVinoRow()}</tbody>
        </Table>
      </Col>
    </Row>
  );
};

export default Vino;
