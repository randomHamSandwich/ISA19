insert into lek (naziv) values  ('pracetamol');
insert into lek (naziv) values  ('farin');
insert into lek (naziv) values  ('andol');
insert into lek (naziv) values  ('palitrex');

insert into roles (naziv_role) values ('LEKAR');
insert into roles (naziv_role) values ('MEDICINSKA_SESTRA');
insert into roles (naziv_role) values ('ADMINISTRATOR_KLINICKOG_CENTRA');
insert into roles (naziv_role) values ('ADMINISTRAOR_KLINIKE');
insert into roles (naziv_role) values ('PACIJENT');



insert into klinika(naziv,ulica,broj_ulice,drzava,grad,opis) values
('Klinika1111','Ulica111','12','Srbija','Novi Sad','opis');
insert into klinika(naziv,ulica,broj_ulice,drzava,grad,opis) values
('Klinika222222','Ulica2222','13','Srbija','Novi Sad','opis');
insert into klinika(naziv,ulica,broj_ulice,drzava,grad,opis) values
('Klinika33333333','Ulica33333','14','Srbija','Novi Sad','opis');

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona) values
('AK', 'antonije@gmail.com','Antonije', 'Akelic','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Cara Dusana', '15','Novi Sad', 'Srbija', 'jmbg1111111111', 'ACTIVATED_IN_USE', '061111111111');

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona) values
('AKC', 'andrej@gmail.com','Avramov', 'Avramov','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Gogoljeva', '5','Novi Sad', 'Srbija', 'jmbg2222222', 'ACTIVATED_IN_USE', '0622222222222');

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona, specijalizacija) values
('LEKAR', 'leonard@gmail.com','Leonard', 'Maxwell','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Puskinova', '22','Novi Sad', 'Srbija', 'jmbg333333333', 'ACTIVATED_IN_USE', '063333333333', 'NEUROLOGIJA');

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona, specijalizacija) values
('LEKAR', 'lekr222@gmail.com','Marko', 'Medic','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Cara Lazara', '1','Novi Sad', 'Srbija', 'jmbg444444444', 'ACTIVATED_IN_USE', '5465161684', 'NEUROLOGIJA');

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona, specijalizacija) values
('LEKAR', 'lekar333@gmail.com','Nikola', 'Isakov','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Narodnog Fronta', '12','Novi Sad', 'Srbija', 'jmbg5555555', 'ACTIVATED_IN_USE', '065465485', 'OFTALMOLOGIJA');

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona, specijalizacija) values
('LEKAR', 'lekar4444@gmail.com','Danilo', 'Dalmic','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Hopovska', '8','Novi Sad', 'Srbija', 'jmbg66666666', 'ACTIVATED_IN_USE', '654516105', 'OFTALMOLOGIJA');

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona, specijalizacija) values
('LEKAR', 'lekar55555@gmail.com','Mima', 'Gvozdic','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Resavska', '32','Novi Sad', 'Srbija', 'jmbg88888888', 'ACTIVATED_IN_USE', '654516105', 'INFEKTOLOGIJA');

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona, specijalizacija) values
('LEKAR', 'lekar66666@gmail.com','Natasa', 'Aleksic','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Vojvodjanska', '43','Novi Sad', 'Srbija', 'jmbg999999', 'ACTIVATED_IN_USE', '654516105', 'INFEKTOLOGIJA');

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona, specijalizacija) values
('LEKAR', 'lekar7777@gmail.com','Mirosava', 'Markovic','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Posarevska', '21','Novi Sad', 'Srbija', 'jmbgAAAAAAAA', 'ACTIVATED_IN_USE', '3424325', 'INFEKTOLOGIJA');



insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona) values
('SESTRA', 'milka@gmail.com','Milka', 'Saric','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Zimanova', '145','Novi Sad', 'Srbija', 'jmbg777777777', 'ACTIVATED_IN_USE', '06444444444444');

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona, version) values
('PACIJENT', 'peraspringuser19@gmail.com','Pera', 'Pavlic','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Pavla Papa', '13','Novi Sad', 'Srbija', 'jmb888888', 'ACTIVATED_IN_USE', '0655555555555', 0);

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona) values
('PACIJENT', 'mirjanaspringuser19@gmail.com','Mirjana', 'Mackic','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Jug Bogdana', '67','Novi Sad', 'Srbija', 'jmbBBBBBBBB', 'ACTIVATED_IN_USE', '5468464431384');

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona) values
('PACIJENT', 'milan@gmail.com','Milan', 'Kovacevic','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Majevicka', '11','Beograd', 'Srbija', 'jmbCCCCCCCCC', 'ACTIVATED_IN_USE', '498432185498786');

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona) values
('SESTRA', 'sonja@gmail.com','Sonja', 'Sanjic','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Hopova', '231','Novi Sad', 'Srbija', 'jmbgDDDDDDD', 'ACTIVATED_IN_USE', '1231231231');

insert into korisnik(tipp, email,ime,prezime,lozinka,ulica,broj_ulice,grad,drzava,jmbg,status_korisnika,broj_telefona) values
('SESTRA', 'ivanka@gmail.com','Ivanka', 'Ostric','$2a$10$YDrhoDY60oavj/E0tHUQYOhpg1tm1kIM/m8xg.nvUl6GVF0qBjtIG', 'Zimanova', '145','Becek', 'Srbija', 'jmbgEEEEEEE', 'ACTIVATED_IN_USE', '333333333333');


--insert into karton


insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'antonije@gmail.com' and naziv_role='ADMINISTRAOR_KLINIKE';
insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'andrej@gmail.com' and naziv_role='ADMINISTRATOR_KLINICKOG_CENTRA';
insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'leonard@gmail.com' and naziv_role='LEKAR';
insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'lekr222@gmail.com' and naziv_role='LEKAR';
insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'lekar333@gmail.com' and naziv_role='LEKAR';
insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'lekar4444@gmail.com' and naziv_role='LEKAR';
insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'lekar55555@gmail.com' and naziv_role='LEKAR';
insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'lekar66666@gmail.com' and naziv_role='LEKAR';
insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'lekar7777@gmail.com' and naziv_role='LEKAR';

insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'milka@gmail.com' and naziv_role='MEDICINSKA_SESTRA';
insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'sonja@gmail.com' and naziv_role='MEDICINSKA_SESTRA';
insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'ivanka@gmail.com' and naziv_role='MEDICINSKA_SESTRA';
insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'peraspringuser19@gmail.com' and naziv_role='PACIJENT';
insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'mirjanaspringuser19@gmail.com' and naziv_role='PACIJENT';
insert into korisnik_role (id_osoba, id_rola) select id_osoba , id_rola from korisnik , roles where email = 'milan@gmail.com' and naziv_role='PACIJENT';

--update korisnik ko, klinika kl set ko.id_klinika = kl.id_klinika where ko.email ="antonije@gmail.com" and kl.naziv ="Klinika1111";
update korisnik ko, klinika kl set ko.id_klinika = kl.id_klinika where ko.email ="andrej@gmail.com" and kl.naziv ="Klinika1111";
update korisnik ko, klinika kl set ko.id_klinika = kl.id_klinika where ko.email ="leonard@gmail.com" and kl.naziv ="Klinika1111";
update korisnik ko, klinika kl set ko.id_klinika = kl.id_klinika where ko.email ="milka@gmail.com" and kl.naziv ="Klinika1111";

update korisnik ko, klinika kl set ko.id_klinika = kl.id_klinika where ko.email ="lekr222@gmail.com" and kl.naziv ="Klinika1111";
update korisnik ko, klinika kl set ko.id_klinika = kl.id_klinika where ko.email ="lekar333@gmail.com" and kl.naziv ="Klinika222222";

update korisnik ko, klinika kl set ko.id_klinika = kl.id_klinika where ko.email ="lekar4444@gmail.com" and kl.naziv ="Klinika222222";
update korisnik ko, klinika kl set ko.id_klinika = kl.id_klinika where ko.email ="lekar55555@gmail.com" and kl.naziv ="Klinika33333333";

update korisnik ko, klinika kl set ko.id_klinika = kl.id_klinika where ko.email ="lekar66666@gmail.com" and kl.naziv ="Klinika33333333";
update korisnik ko, klinika kl set ko.id_klinika = kl.id_klinika where ko.email ="lekar7777@gmail.com" and kl.naziv ="Klinika1111";

update korisnik ko, klinika kl set ko.id_klinika = kl.id_klinika where ko.email ="sonja@gmail.com" and kl.naziv ="Klinika222222";
update korisnik ko, klinika kl set ko.id_klinika = kl.id_klinika where ko.email ="ivanka@gmail.com" and kl.naziv ="Klinika33333333";




insert into kalendar_dogadjaja (pocetak,kraj,tip_dogadjaja, id_medicinsko_osoblje) values (CURDATE(),CURDATE() + INTERVAL 5 DAY, 'ODOBRENI_ODMOR', '3');
--insert into kalendar_dogadjaja (pocetak,kraj,tip_dogadjaja, id_medicinsko_osoblje) values (CURDATE(),CURDATE() + INTERVAL 5 DAY, 'ODOBRENI_ODMOR', '3');

insert into usluga (naziv_usluge,id_klinika, cena) values ('NEUROLOGIJA',1,3000);
insert into usluga (naziv_usluge,id_klinika, cena) values ('INFEKTOLOGIJA',1,4000);

insert into usluga (naziv_usluge,id_klinika, cena) values ('OFTALMOLOGIJA',2,5000);

insert into usluga (naziv_usluge,id_klinika, cena) values ('INFEKTOLOGIJA',3,3500);



INSERT INTO dijagnoza(naziv_dijagnoza, id_administartor_klinicnog_centra) values ('Erozija roznjace', 1);
INSERT INTO dijagnoza(naziv_dijagnoza, id_administartor_klinicnog_centra) values ('Astigmatizam', 1);
INSERT INTO dijagnoza(naziv_dijagnoza, id_administartor_klinicnog_centra) values ('Dalekovidost', 1);
INSERT INTO dijagnoza(naziv_dijagnoza, id_administartor_klinicnog_centra) values ('Kratkovidost', 1);
INSERT INTO dijagnoza(naziv_dijagnoza, id_administartor_klinicnog_centra) values ('FRAXA', 1);
INSERT INTO dijagnoza(naziv_dijagnoza, id_administartor_klinicnog_centra) values ('SBMA', 1);
INSERT INTO dijagnoza(naziv_dijagnoza, id_administartor_klinicnog_centra) values ('CADSIL', 1);
INSERT INTO dijagnoza(naziv_dijagnoza, id_administartor_klinicnog_centra) values ('CMT/HNPP', 1);
INSERT INTO dijagnoza(naziv_dijagnoza, id_administartor_klinicnog_centra) values ('Lajmska bolest', 1);
INSERT INTO dijagnoza(naziv_dijagnoza, id_administartor_klinicnog_centra) values ('Groznica zapadnog Nila', 1);
INSERT INTO dijagnoza(naziv_dijagnoza, id_administartor_klinicnog_centra) values ('Kostolomna groznica', 1);
INSERT INTO dijagnoza(naziv_dijagnoza, id_administartor_klinicnog_centra) values ('Hepatitis A', 1);
INSERT INTO dijagnoza(naziv_dijagnoza, id_administartor_klinicnog_centra) values ('Hepatitis B', 1);
INSERT INTO dijagnoza(naziv_dijagnoza, id_administartor_klinicnog_centra) values ('Hepatitis C', 1);
INSERT INTO dijagnoza(naziv_dijagnoza, id_administartor_klinicnog_centra) values ('Hepatitis D', 1);
INSERT INTO dijagnoza(naziv_dijagnoza, id_administartor_klinicnog_centra) values ('Hepatitis E', 1);


INSERT INTO pregled (vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra,id_pacijent,status, id_dijagnoza, id_klinika) 
values(CURDATE() - INTERVAL 2 MONTH + INTERVAL  8 HOUR + INTERVAL 30 MINUTE, CURDATE() - INTERVAL 2 MONTH + INTERVAL  9 HOUR , 3, 10, 11,  'IZVRSEN_PREGLED', 6, 1);  
INSERT INTO pregled (vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra,id_pacijent,status, id_dijagnoza, id_klinika) 
values(CURDATE() - INTERVAL 3 MONTH + INTERVAL  9 HOUR + INTERVAL 30 MINUTE, CURDATE() - INTERVAL 2 MONTH + INTERVAL  10 HOUR , 5, 14, 11,  'IZVRSEN_PREGLED', 1, 2);  
INSERT INTO pregled (vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra,id_pacijent,status, id_dijagnoza, id_klinika) 
values(CURDATE() - INTERVAL 4 MONTH + INTERVAL  10 HOUR + INTERVAL 30 MINUTE, CURDATE() - INTERVAL 2 MONTH + INTERVAL  11 HOUR , 5, 14, 11,  'IZVRSEN_PREGLED', 2, 2); 

INSERT INTO pregled (vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra,id_pacijent,status, id_klinika) 
values(CURDATE() + INTERVAL 3 DAY + INTERVAL  8 HOUR , CURDATE()  + INTERVAL 3 DAY  + INTERVAL  8 HOUR + INTERVAL 30 MINUTE, 4, 10, 11,  'ZAKAZAN_PREGLED',1); 
INSERT INTO pregled (vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra,id_pacijent,status, id_klinika) 
values(CURDATE() + INTERVAL 3 DAY + INTERVAL  8 HOUR + INTERVAL 30 MINUTE, CURDATE()  + INTERVAL 3 DAY  + INTERVAL  9 HOUR , 4, 10, 11,  'ZAKAZAN_PREGLED',1); 


INSERT INTO karton (krvna_grupa,tezina,visina,id_pacijent) values('A+', 89, 180, 11);
INSERT INTO karton (krvna_grupa,tezina,visina,id_pacijent) values('AB-', 67, 168, 12);
INSERT INTO karton (krvna_grupa,tezina,visina,id_pacijent) values('B+', 77, 177, 13);

insert into operacija (id_pacijent, id_klinika, status , vreme_pocetka, vreme_zavrsetka) value (11, 2, 'IZVRSENA_OPERACIJA', CURDATE() - INTERVAL 6 MONTH + INTERVAL  9 HOUR, CURDATE() - INTERVAL 6 MONTH + INTERVAL  13 HOUR);
insert into lekar_operacija (id_lekar, id_operacija) values (5,1);
insert into lekar_operacija (id_lekar, id_operacija) values (6,1);
insert into operacija (id_pacijent, id_klinika, status , vreme_pocetka, vreme_zavrsetka) value (11, 1, 'IZVRSENA_OPERACIJA', CURDATE() - INTERVAL 3 MONTH + INTERVAL 3 Day+ INTERVAL  14 HOUR, CURDATE() - INTERVAL 3 MONTH +INTERVAL 3 Day+ INTERVAL  13 HOUR);
insert into lekar_operacija (id_lekar, id_operacija) values (3,2);
insert into lekar_operacija (id_lekar, id_operacija) values (4,2);

INSERT INTO pregled (id_klinika, vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra ,status) 
values(1, CURDATE() + INTERVAL 25 DAY + INTERVAL  8 HOUR , CURDATE()  + INTERVAL 25 DAY  + INTERVAL  8 HOUR + INTERVAL 30 MINUTE, 3, 10,    'BRZI_PREGLED'); 

INSERT INTO pregled (id_klinika, vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra ,status) 
values(1, CURDATE() + INTERVAL 25 DAY + INTERVAL  8 HOUR + INTERVAL 30 MINUTE, CURDATE()  + INTERVAL 25 DAY  + INTERVAL  9 HOUR , 3, 10,    'BRZI_PREGLED'); 

INSERT INTO pregled (id_klinika, vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra ,status) 
values(1, CURDATE() + INTERVAL 25 DAY + INTERVAL  9 HOUR , CURDATE()  + INTERVAL 25 DAY  + INTERVAL  9 HOUR  + INTERVAL 30 MINUTE, 3, 10,    'BRZI_PREGLED'); 

INSERT INTO pregled (id_klinika, vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra ,status) 
values(1, CURDATE() + INTERVAL 25 DAY + INTERVAL  9 HOUR + INTERVAL 30 MINUTE, CURDATE()  + INTERVAL 25 DAY  + INTERVAL  10 HOUR , 3, 10,    'BRZI_PREGLED'); 

INSERT INTO pregled (id_klinika, vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra ,status) 
values(1, CURDATE() + INTERVAL 25 DAY + INTERVAL  10 HOUR , CURDATE()  + INTERVAL 25 DAY  + INTERVAL  10 HOUR + INTERVAL 30 MINUTE, 3, 10,    'BRZI_PREGLED'); 

INSERT INTO pregled (id_klinika, vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra ,status) 
values(1, CURDATE() + INTERVAL 25 DAY + INTERVAL  10 HOUR + INTERVAL 30 MINUTE, CURDATE()  + INTERVAL 25 DAY  + INTERVAL  11 HOUR , 3, 10,    'BRZI_PREGLED'); 

INSERT INTO pregled (id_klinika, vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra ,status) 
values(1, CURDATE() + INTERVAL 25 DAY + INTERVAL  11 HOUR , CURDATE()  + INTERVAL 25 DAY  + INTERVAL  11 HOUR + INTERVAL 30 MINUTE, 3, 10,    'BRZI_PREGLED'); 

INSERT INTO pregled (id_klinika, vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra ,status) 
values(1, CURDATE() + INTERVAL 25 DAY + INTERVAL  11 HOUR + INTERVAL 30 MINUTE, CURDATE()  + INTERVAL 25 DAY  + INTERVAL  12 HOUR , 3, 10,    'BRZI_PREGLED'); 

INSERT INTO pregled (id_klinika, vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra ,status) 
values(1, CURDATE() + INTERVAL 25 DAY + INTERVAL  12 HOUR , CURDATE()  + INTERVAL 25 DAY  + INTERVAL  12 HOUR + INTERVAL 30 MINUTE, 3, 10,    'BRZI_PREGLED'); 

INSERT INTO pregled (id_klinika, vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra ,status) 
values(1, CURDATE() + INTERVAL 25 DAY + INTERVAL  12 HOUR + INTERVAL 30 MINUTE, CURDATE()  + INTERVAL 25 DAY  + INTERVAL  13 HOUR , 3, 10,    'BRZI_PREGLED'); 

INSERT INTO pregled (id_klinika, vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra ,status) 
values(1, CURDATE() + INTERVAL 25 DAY + INTERVAL  13 HOUR , CURDATE()  + INTERVAL 25 DAY  + INTERVAL  13 HOUR + INTERVAL 30 MINUTE, 3, 10,    'BRZI_PREGLED'); 

INSERT INTO pregled (id_klinika, vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra ,status) 
values(1, CURDATE() + INTERVAL 25 DAY + INTERVAL  13 HOUR + INTERVAL 30 MINUTE, CURDATE()  + INTERVAL 25 DAY  + INTERVAL  14 HOUR , 3, 10,    'BRZI_PREGLED'); 

INSERT INTO pregled (id_klinika, vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra ,status) 
values(1, CURDATE() + INTERVAL 25 DAY + INTERVAL  14 HOUR , CURDATE()  + INTERVAL 25 DAY  + INTERVAL  14 HOUR + INTERVAL 30 MINUTE, 3, 10,    'BRZI_PREGLED'); 

INSERT INTO pregled (id_klinika, vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra ,status) 
values(1, CURDATE() + INTERVAL 25 DAY + INTERVAL  14 HOUR + INTERVAL 30 MINUTE, CURDATE()  + INTERVAL 25 DAY  + INTERVAL  15 HOUR , 3, 10,    'BRZI_PREGLED'); 

INSERT INTO pregled (id_klinika, vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra ,status) 
values(1, CURDATE() + INTERVAL 25 DAY + INTERVAL  15 HOUR , CURDATE()  + INTERVAL 25 DAY  + INTERVAL  15 HOUR + INTERVAL 30 MINUTE, 3, 10,    'BRZI_PREGLED'); 

INSERT INTO pregled (id_klinika, vreme_pocetka,vreme_zavrsetka,id_lekar,id_medicinska_sestra ,status) 
values(1, CURDATE() + INTERVAL 25 DAY + INTERVAL  15 HOUR + INTERVAL 30 MINUTE, CURDATE()  + INTERVAL 25 DAY  + INTERVAL  16 HOUR , 3, 10,    'BRZI_PREGLED'); 



