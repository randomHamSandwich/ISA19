insert into lek (naziv) values  ('pracetamol');
insert into lek (naziv) values  ('farin');
insert into lek (naziv) values  ('andol');
insert into lek (naziv) values  ('palitrex');

insert into roles (naziv_role) values ('LEKAR');
insert into roles (naziv_role) values ('MEDICINSKA_SESTRA');
insert into roles (naziv_role) values ('ADMINISTRATOR_KLINICKOG_CENTRA');
insert into roles (naziv_role) values ('ADMINISTRAOR_KLINIKE');
insert into roles (naziv_role) values ('PACIJENT');



insert into klinika(naziv,ulica,broj_ulice,drzava,grad,opis,ocena_klinike) values
('Klinika1111','Ulica111','12','Srbija','Novi Sad','opis',4.5);
insert into klinika(naziv,ulica,broj_ulice,drzava,grad,opis,ocena_klinike) values
('Klinika222222','Ulica2222','13','Srbija','Novi Sad','opis',4.1);
insert into klinika(naziv,ulica,broj_ulice,drzava,grad,opis,ocena_klinike) values
('Klinika33333333','Ulica33333','14','Srbija','Novi Sad','opis',3.7);

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona) values
('AK', 'antonije@gmail.com','Antonije', 'Akelic','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Cara Dusana', '15','Novi Sad', 'Srbija', 'jmbg1111111111', 'ACTIVATED_IN_USE', '061111111111');

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona) values
('AKC', 'andrej@gmail.com','Avramov', 'Avramov','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Gogoljeva', '5','Novi Sad', 'Srbija', 'jmbg2222222', 'ACTIVATED_IN_USE', '0622222222222');

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona, specijalizacija) values
('LEKAR', 'leonard@gmail.com','Leonard', 'Maxwell','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Puskinova', '22','Novi Sad', 'Srbija', 'jmbg333333333', 'ACTIVATED_IN_USE', '063333333333', 'NEUROLOGIJA');

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona) values
('SESTRA', 'milka@gmail.com','Milka', 'Saric','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Zimanova', '145','Novi Sad', 'Srbija', 'jmbg4444444', 'ACTIVATED_IN_USE', '06444444444444');

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona) values
('PACIJENT', 'pera@gmail.com','pera', 'Pavlic','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Pavla Papa', '13','Novi Sad', 'Srbija', 'jmbg55555', 'ACTIVATED_IN_USE', '0655555555555');

--insert into karton


insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'antonije@gmail.com' and naziv_role='ADMINISTRAOR_KLINIKE';
insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'andrej@gmail.com' and naziv_role='ADMINISTRATOR_KLINICKOG_CENTRA';
insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'leonard@gmail.com' and naziv_role='LEKAR';
insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'milka@gmail.com' and naziv_role='MEDICINSKA_SESTRA';
insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'pera@gmail.com' and naziv_role='PACIJENT';

update korisnik ko, klinika kl set ko.id_klinika = kl.id_klinika where ko.email ="antonije@gmail.com" and kl.naziv ="Klinika1111";
update korisnik ko, klinika kl set ko.id_klinika = kl.id_klinika where ko.email ="andrej@gmail.com" and kl.naziv ="Klinika1111";
update korisnik ko, klinika kl set ko.id_klinika = kl.id_klinika where ko.email ="leonard@gmail.com" and kl.naziv ="Klinika1111";
update korisnik ko, klinika kl set ko.id_klinika = kl.id_klinika where ko.email ="milka@gmail.com" and kl.naziv ="Klinika1111";

