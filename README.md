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

  Programul pe care l-am realizat pana acum este impartit in 5 pachete:
- **model**-
  In acest pachet, am creat o clasa pentru fiecare tabel al bazei de date, folosind anotatiile corespunzatoare pentru primary, respectiv foreign key;
- **repository**-
  Pentru fiecare tabel, am creat cate o interfata care extinde JPARepository(_Repository), pentru a folosi query-urile usoare, fara a le scrie implementarea direct;
- **service**-
  Am implementat cate o interfata(_Service) pentru fiecare entitate, care are ca metode tot de ce am nevoie pentru interogarea tabelelor din baza de date. Pentru fiecare din acestea, am creat o clasa(_ServiceImpl) care o extinde, in care am o dependinta pentru interfata corespunzatoare din repository. Am implementat in acest mod, pentru a face posibila decuplarea de baza de date.
- **controller**-
  Si aici, am creat cate o clasa pentru fiecare tabel din baza de date; in acestea avem o dependinta catre clasele corespunzatoare(_ServiceImpl). Ne creem endpoint-uri pe baza metodelor din service.
- **observer**-
  Deocamdata, in acest pachet este o singura clasa AdminAction, care contine o metoda de notificare pentru un User. Aceasta se va apela pentru fiecare user, in momentul in care adminul decide sa acorde voucher cadou.
  
