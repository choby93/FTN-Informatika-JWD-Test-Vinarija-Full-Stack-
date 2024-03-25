import React, {useState } from "react";
import { Button, Col, Form } from "react-bootstrap";
import Axios from "../../apis/Axios";
import { useNavigate } from "react-router-dom";

const VinoRow = (props) => {
  const navigate = useNavigate();
  const vinoId = props.vino.id;
  const admin = window.localStorage["role"] === "ROLE_ADMIN";
  const user = window.localStorage["role"] === "ROLE_KORISNIK";
  const [novaKolicina, setNovaKolicina] = useState({
    kolicinaZaIzmenu: "",
  });
  //brisanje vina
  const doDelete = () => {
    let confirmDelete = window.confirm("Da li ste sigurni da želite obrisati?");

    if (confirmDelete) {
      Axios.delete("/vina/" + vinoId)
        .then((result) => {
          console.log(result);
          window.location.reload();
        })
        .catch((error) => {
          console.log(error);
          alert("Došlo je do greške u brisanju vina");
        });
    } else {
      navigate("/vina");
    }
  };

  //narucivanje vina
  const narucivanje = (vinoId) => {
    const dto = {
      kolicinaZaIzmenu: novaKolicina.kolicinaZaIzmenu,
    };

    Axios.put("/vina/" + vinoId + "/nabavka", dto)
      .then((res) => {
        console.log(res);
        window.location.reload();
      })
      .catch((err) => {
        console.log(err);
        alert("greska pri narucivanju");
      });
  };

  //kupovina vina
  const kupovina = (vinoId) => {
    const dto = {
      kolicinaZaIzmenu: novaKolicina.kolicinaZaIzmenu,
    };

    Axios.put("/vina/" + vinoId + "/kupovina", dto)
      .then((res) => {
        console.log(res);
        window.location.reload();
      })
      .catch((err) => {
        console.log(err);
        alert("Greška pri kupovini");
      });
  };

  return (
    <tr key={props.vino.vino}>
      <td>{props.vino.ime}</td>
      <td>{props.vino.vinarijaIme}</td>
      <td>{props.vino.tipVinaIme}</td>
      {user ? <td>{props.vino.opis}</td> : null}
      <td>{props.vino.godinaProizvodnje}</td>
      <td>{props.vino.cenaFlase}</td>
      {admin ? <td>{props.vino.brojDostupnihFlasa}</td> : null}
      <td className="d-flex gap-4">
        {admin ? (
          <Col className="d-flex gap-3">
            <Button variant="danger" onClick={doDelete}>
              Obriši
            </Button>
            {props.vino.brojDostupnihFlasa < 10 ? (
              <Col className="d-flex gap-3">
                <Form.Control
                  type="number"
                  style={{ width: "80px" }}
                  name="kolicinaZaIzmenu"
                  onChange={(e) =>
                    setNovaKolicina({ kolicinaZaIzmenu: e.target.value })
                  }
                ></Form.Control>
                <Button onClick={() => narucivanje(props.vino.id)}>
                  Naruči
                </Button>
              </Col>
            ) : null}
          </Col>
        ) : (
          <Col className="d-flex gap-3">
            {props.vino.brojDostupnihFlasa > 0 ? (
              <>
                <Form.Control
                  style={{ width: "80px" }}
                  name="kolicinaZaIzmenu"
                  onChange={(e) =>
                    setNovaKolicina({ kolicinaZaIzmenu: e.target.value })
                  }
                ></Form.Control>
                <Button onClick={() => kupovina(props.vino.id)}>Kupi</Button>
              </>
            ) : (
              <h4 style={{ color: "red" }}>Raspordato!</h4>
            )}
          </Col>
        )}
      </td>
    </tr>
  );
};

export default VinoRow;
