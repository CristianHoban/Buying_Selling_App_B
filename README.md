# Site de vanzare-cumparare
Site-ul la care m-am gandit va avea urmatoarele functionalitati:

- **Pagina de LOGIN si REGISTER** : aceasta permite utilizatorului sa se autentifice folosind o adresa de email. Va cere de asemenea si anumite date auxiliare cum ar fi adresa;
    
- **Introducerea unui produs care va fi dat spre vanzare**: aici, se vor introduce mai intai o serie de poze cu obiectul respectiv(va fi un numar maxim de poze), starea acestuia, pretul, o scurta descriere, etc.;
    
- **Vizualizarea profilului**: se va deschide o pagina pe care vor fi afisate informatiile personale, aici existand posibilitatea de a le modifica;
    
- **Cautarea unor produse dupa anumite criterii**: Va fi disponibil un camp pentru filtrarea produselor, astfel se pot bifa caracteristicile pe care produsul pe care doresti sa il achizitionezi sa le aiba;
    
- **Sistem de evaluare si recenzii**: Dupa realizarea cumpararii unui produs, va exista posibilitatea sa adaugi o recenzie pentru persoana care l-a vandut, aceasta aparand pe profilul acesteia;
    
- **Promovarea produselor**: se va putea alege optiunea de a promova produsul pe care il vinzi, contra unei sume de bani. Aceasta va consta in aparitia produsului respectiv in capul listei produselor;
  
- **Acordarea voucher-elor cadou**: adminul va avea posibilitatea sa acorde o anumita suma cadou tuturor utilizatorilor cand acesta doreste;
    
## Baza de date

Baza de date pe care am gandit-o contine 5 tabele:
- User
- Product
- ProductPhoto
- Review
- Trade,
  
fiecare cu atributele care se pot observa in diagrama de baze de date de mai jos:

<p align="center">
  <img src="https://github.com/CristianHoban/PS_Project/assets/126794626/54b9728a-7106-4b76-847f-d7f26d9bcbcc" width="700">
</p>


### Relatii intre tabele

- Relatie **one-to-many** intre *User* si *Product*: fiecare utilizator poate incarca mai multe produse spre vanzare;
- Relatie **one-to-many** intre *Product* si *ProductPhoto*: fiecare produs poate avea mai multe poze;
- Relatie **one-to-many** intre *User* si *Review*: fiecare user poate primi mai multe recenzii pentru profilul lui;
- Relatie **one-to-one** intre *Product* si *Trade*: un produs poate fi atribuit unei singure tranzactii;
- 2 relatii **one-to-many** intre *Product* si *Trade*: o tranzactie poate avea un singur vanzator si un singur cumparator, dar un utilizator poate fi parte a mai multor tranzactii.(Edit: am eliminat aceste 2 relatii pentru a facilita implementarea. In cazul in care lasam aceste relatii, in momentul in care stergeam un User, se stergea si tranzactia facuta, astfel ca in cazul in care celalalt User participant la tranzactie voia in continuare sa-si vizualizeze tranzactia aceasta nu mai exista. In loc de id-uri am folosit email-urile partilor tranzactiei, fara a lega direct tabelele User si Trade.)

  ## Implementare

  Programul pe care l-am realizat pana acum este impartit in 6 pachete:
- **model**-
  In acest pachet, am creat o clasa pentru fiecare tabel al bazei de date, folosind anotatiile corespunzatoare pentru primary, respectiv foreign key;
- **repository**-
  Pentru fiecare tabel, am creat cate o interfata care extinde JPARepository(_Repository), pentru a folosi query-urile usoare, fara a le scrie implementarea direct;
- **data** -
    Pentru fiecare tabel, am creat cate o interfata(_Contract), care dupa cum le si sugereaza numele, reprezinta un contract prin care datele se transmit la service. In fiecare dintre acestea, sunt definite metode pe care clasele care o sa implementeze interfetele vor trebui sa le suprascrie. Pe langa interfete, pentru fiecare tabel am creat si cate o clasa(_Data), care implementeaza interfata corespunzatoare si are cate o dependinta pentru _Repository. Aceste clase sunt folosite pentru a comunica cu baza de date. Folosind acest pachet aditional, am facut programul decuplat, fiind astfel posibila testarea.
- **service**-
  Am implementat cate o clasa(_Service) pentru fiecare entitate, care are o dependinta catre contractul fiecarui tabel, si apeleaza fiecare metoda cu ajutorul metodelor transmise prin contracte.
- **controller**-
  Si aici, am creat cate o clasa pentru fiecare tabel din baza de date; in acestea avem o dependinta catre clasele corespunzatoare(_ServiceImpl). Ne creem endpoint-uri pe baza metodelor din service.
- **observer**-
  Deocamdata, in acest pachet este o singura clasa AdminAction, care contine o metoda de notificare pentru un User. Aceasta se va apela pentru fiecare user, in momentul in care adminul decide sa acorde voucher cadou.

## Endpoint-uri
Pentru fiecare tabel din baza de date, am implementat cate un controller in care sunt construite endpoint-urile de care voi avea nevoie:
### User
- http://localhost:8082/api/users/add - endpoint pentru adaugarea unui user in baza de date
- http://localhost:8082/api/users/get/{id} - endpoint pentru cautarea unui user cu un ID specific in baza de date
- http://localhost:8082/api/users/put/{id} - endpoint pentru modificarea unui user cu un ID specific din baza de date
- http://localhost:8082/api/users/delete/{id} - endpoint pentru stergerea unui user cu ID specific din baza de date
- http://localhost:8082/api/users/admin/updateBalances - endpoint folosit doar pentru admin, pentru a modifica balantele tuturor user-ilor

### Product
- http://localhost:8082/api/products/add - endpoint pentru adaugarea unui produs in baza de date
- http://localhost:8082/api/products/get/{id} - endpoint pentru cautarea unui produs cu un ID specific in baza de date
- http://localhost:8082/api/products/put/{id} - endpoint pentru modificarea unui produs cu un ID specific din baza de date
- http://localhost:8082/api/products/delete{id} - endpoint pentru stergerea unui produs cu un ID specific din baza de date

### Trade
- http://localhost:8082/api/trades/add - endpoint pentru adaugarea unei tranzactii in baza de date
- http://localhost:8082/api/trades/get/{id} - endpoint pentru cautarea unei tranzactii cu un ID specific in baza de date
- http://localhost:8082/api/trades/put/{id} - endpoint pentru modificarea unei tranzactii cu un ID specific din baza de date
- http://localhost:8082/api/trades/delete{id} - endpoint pentru stergerea unei tranzactii cu un ID specific din baza de date
- http://localhost:8082/api/trades/getTradesByEmail/{email} - endpoint pentru cautarea tranzactiilor in care un user cu un email specific este implicat

### Review
- http://localhost:8082/api/reviews/add - endpoint pentru adaugarea unei recenzii in baza de date
- http://localhost:8082/api/reviews/get/{id} - endpoint pentru cautarea unei recenzii cu un ID specific in baza de date
- http://localhost:8082/api/reviews/put/{id} - endpoint pentru modificarea unei recenzii cu un ID specific din baza de date
- http://localhost:8082/api/reviews/delete{id} - endpoint pentru stergerea unei recenzii cu un ID specific din baza de date

### Photo
- http://localhost:8082/api/photos/add - endpoint pentru adaugarea unei imagini in baza de date
- http://localhost:8082/api/photos/get/{id} - endpoint pentru cautarea unei imagini cu un ID specific in baza de date
- http://localhost:8082/api/photos/put/{id} - endpoint pentru modificarea unei imagini cu un ID specific din baza de date
- http://localhost:8082/api/photos/delete{id} - endpoint pentru stergerea unei imagini cu un ID specific din baza de date
