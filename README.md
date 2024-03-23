# Site de vanzare-cumparare
Site-ul la care m-am gandit va avea urmatoarele functionalitati:

- **Pagina de LOGIN si REGISTER** : aceasta permite utilizatorului sa se autentifice folosind o adresa de email. Va cere de asemenea si anumite date auxiliare cum ar fi adresa;
    
- **Introducerea unui produs care va fi dat spre vanzare**: aici, se vor introduce mai intai o serie de poze cu obiectul respectiv(va fi un numar maxim de poze), starea acestuia, pretul, o scurta descriere, etc.;
    
- **Vizualizarea profilului**: se va deschide o pagina pe care vor fi afisate informatiile personale, aici existand posibilitatea de a le modifica;
    
- **Cautarea unor produse dupa anumite criterii**: Va fi disponibil un camp pentru filtrarea produselor, astfel se pot bifa caracteristicile pe care produsul pe care doresti sa il achizitionezi sa le aiba;
    
- **Sistem de evaluare si recenzii**: Dupa realizarea cumpararii unui produs, va exista posibilitatea sa adaugi o recenzie pentru persoana care l-a vandut, aceasta aparand pe profilul acesteia;
    
- **Promovarea produselor**: se va putea alege optiunea de a promova produsul pe care il vinzi, contra unei sume de bani. Aceasta va consta in aparitia produsului respectiv in capul listei produselor;
    
## Baza de date

Baza de date pe care am gandit-o contine 5 tabele:
- User
- Product
- ProductPhoto
- Review
- Trade,
  
fiecare cu atributele care se pot observa in diagrama de baze de date de mai jos:

<p align="center">
  <img src="https://github.com/CristianHoban/PS_Project/assets/126794626/f18d2729-1136-423c-b964-69e94696c426" width="700">
</p>

### Relatii intre tabele

- Relatie **one-to-many** intre *User* si *Product*: fiecare utilizator poate incarca mai multe produse spre vanzare;
- Relatie **one-to-many** intre *Product* si *ProductPhoto*: fiecare produs poate avea mai multe poze;
- Relatie **one-to-many** intre *User* si *Review*: fiecare user poate primi mai multe recenzii pentru profilul lui;
- Relatie **one-to-one** intre *Product* si *Trade*: un produs poate fi atribuit unei singure tranzactii;
- 2 relatii **one-to-many** intre *Product* si *Trade*: o tranzactie poate avea un singur vanzator si un singur cumparator, dar un utilizator poate fi parte a mai multor tranzactii.
