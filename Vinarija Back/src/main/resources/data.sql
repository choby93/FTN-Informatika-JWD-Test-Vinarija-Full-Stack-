INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

INSERT INTO tip_vina (id, ime) VALUES (1, "RIZLING");
INSERT INTO tip_vina (id, ime) VALUES (2, " PINOT GRIGIO");
INSERT INTO tip_vina (id, ime) VALUES (3, "SAUVIGNON BLANC");
INSERT INTO tip_vina (id, ime) VALUES (4, "CHARDONNAY");
INSERT INTO tip_vina (id, ime) VALUES (5, "ZINFANDEL");

INSERT INTO vinarija(id, ime, godina_osnivanja) VALUES (1, "Barone Ricasoli", 1114);
INSERT INTO vinarija(id, ime, godina_osnivanja) VALUES (2, "Schloss Johannisberg", 1100);
INSERT INTO vinarija(id, ime, godina_osnivanja) VALUES (3, "Scholl Vollrads", 1211);
INSERT INTO vinarija(id, ime, godina_osnivanja) VALUES (4, "Codorniu", 1551);
INSERT INTO vinarija(id, ime, godina_osnivanja) VALUES (5, "Casa Madero", 1597);

INSERT INTO vino (id, ime, opis, godina_proizvodnje, cena_flase, broj_dostupnih_flasa, tip_vina_id, vinarija_id) 
			VALUES (1, "Domaće vino", "Vino sa tradicijom", 2005, 889.22, 698, 1, 2);
INSERT INTO vino (id, ime, opis, godina_proizvodnje, cena_flase, broj_dostupnih_flasa, tip_vina_id, vinarija_id) 
			VALUES (2, "ABCEF", "Najukusnije vino", 2020, 365.22, 789, 4, 3);
INSERT INTO vino (id, ime, opis, godina_proizvodnje, cena_flase, broj_dostupnih_flasa, tip_vina_id, vinarija_id) 
			VALUES (3, "Ukus", "Samo za prave ljubitelje", 1999, 778.22, 9, 2, 4);
INSERT INTO vino (id, ime, opis, godina_proizvodnje, cena_flase, broj_dostupnih_flasa, tip_vina_id, vinarija_id) 
			VALUES (4, "Armagedon", "Vino koje obara", 1998, 185.22, 25, 5, 5);
INSERT INTO vino (id, ime, opis, godina_proizvodnje, cena_flase, broj_dostupnih_flasa, tip_vina_id, vinarija_id) 
			VALUES (5, "ccc", "Kvalitet na prvom mesti", 2023, 999.22, 99, 3, 1);