Projet Spring Potager ( Axel Mainguy & Corentin Le Bris )

Nous allons créer une application de gestion de potagers permettant à un jardinier de savoir
où sont ses légumes et ce qu’il a à faire. Cette application va permettre de gérer :
- des potagers
- des carrés de potagers dédiés à la culture d’une ou plusieurs plantes
- des plantes sous trois catégories (racine, feuille, fruits)
- des actions à faire (ex : 20/01 : planter mes pommes de terre)
Données
- Potager :
  - localisation (chaine de caractère)
  - nom
  - surface
  - ville
- Carré :
  - dans quel potager il se trouve
  - surface
  - type de sol (argileux etc.)
  - type d’exposition (soleil, ombre, mi ombre)
- Plante :
  - nom
  - type (racine, feuille, fruit)
  - variété
  - surface occupée par un plan (en cm2)
- Une plante dans un carré
  - quantité (nb de plan)
  - date de mise en place
  - date de récolte prévue
- Action
  - date
  - événement
  - lieu (quel potager ou quel carré ou “serre” ou “autre”)
Fonctionnalités (Écrans ou WS)
1. CRUD potagers
2. CRUD carrés
3. CRUD plantes (ici on ne gère pas un stock mais des types de plantes)
4. ajouter des plantes dans le potager
5. Visualiser le potager (avoir une vue d’ensemble)
6. Ajouter des actions
7. Visualiser les actions des 2 prochaines semaines
8. Visualiser la localisation d’une plante (nom ou nom et variété) dans les potagers
(potager, carré, quantité etc.)
9. supprimer un plan du potager
10. Web Service donnant l’ensemble des données d’un potager
11. Web Service donnant l’ensemble des événement sur la serre
12. afficher une page montrant la météo des différents potagers.
13. Web service présentant les carrés inoccupés
Contraintes
A. La somme des tailles des carrés doit être inférieur à celle du potager
B. La surface occupée par les plans ne peut être supérieure à celle du carré.
C. Pas de doublon de plantes (nom, variété)
D. On ne peut entrer une action que si la date est supérieur à la date du jour
E. Pas plus de 3 plantes (du même nom) dans un carré
