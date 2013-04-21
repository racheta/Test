   Rezolvarea proiectului nostru a pornit de la algoritmii de tip Minimax/Negamax. Astfel, ne-am construit o functie(negaMax) care calculeaza cea mai buna miscare
in functie de miscariile viitoare ale botului nostru si de miscarile posibile ale adversarului. Cea mai buna miscare se determina in functie de scorul acesteia.
Astfel, daca acea miscare va aduce victorie, scorul va primi o valoare foarte mare(INF), in schimb o infrangere va aduce un scor foarte mic(-INF). Deasemenea
scorul creste si daca botul va efectua un numar mare de miscari pe harta. Se construieste astfel un arbore de miscari posibile, iar functia noastra va alege
miscarea care intoarce scorul cel mai mare si va intoarce coordonatele mutarii optime. Acesata primeste ca parametrii o matrice de caractere ce reprezinta harta
jocului, caracterele corespunzatoare celor doi jucatori, precum si pozitiile acestora pe harta.
  Functia nextMove primeste ca parametrii harta de joc, caracterul jucatorului precum si pozitiile celor doi jucatori pe harta. Aceasta mai intai transforma harta
intr-o matrice de char si apoi apeleaza functia negaMax in functie de jucatorul primit ca parametru.
  Functia getMove determina, in functie de coordonatele oferite de negaMax, mutarea pe care o face botul(SUS, JOS, DREAPTA, STANGA).
  Mediul de dezvoltare utilizat a fost Eclipse iar limbajul utilizat a fost Java.
  Solutia folosita pentru managementul surselor este github.
  Fiecare membru al echipe a contribuit cu idei legate de modul de implementare al rezolvarii.
