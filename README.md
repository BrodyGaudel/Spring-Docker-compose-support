# Démo Spring Docker Support pour la gestion de réservations hôtelières

Cette démo met en évidence l'utilisation du Spring Docker Support, introduit dans la version Spring Boot 3.1.1, pour faciliter le déploiement de notre application de gestion de réservations hôtelières. Le Spring Docker Support nous permettra d'éviter certaines tâches manuelles, telles que le démarrage de containers, car il créera automatiquement un fichier docker-compose pour nous.

## Prérequis

Assurez-vous d'avoir installé les outils suivants avant de commencer :

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Structure du projet

Notre application de gestion de réservations hôtelières est basée sur Spring Boot et utilise une base de données PostgreSQL pour stocker les données des réservations. Nous avons également utilisé pgAdmin pour visualiser et administrer la base de données.



## Instructions

1. Clonez ce dépôt GitHub :

```bash
git clone https://github.com/BrodyGaudel/Spring-Docker-compose-support.git
cd Spring-Docker-compose-support
```

2. Assurez-vous que Docker et Docker Compose sont installés sur votre système.

3. Demarer Docker

4. Exécutez l'application en utilisant Docker Compose pour gérer les dépendances :

```bash
docker-compose up
```

5. Une fois que tous les conteneurs sont démarrés, vous pourrez accéder à l'application depuis votre navigateur à l'adresse : `http://localhost:8085/app/api/reservations/list`.

6. Utilisez l'application pour gérer les réservations hôtelières. Vous pouvez ajouter, modifier ou supprimer des réservations.

7. Pour accéder à pgAdmin et administrer la base de données PostgreSQL, allez à : `http://localhost:5050`. Les informations de connexion sont spécifiées dans le fichier `docker/docker-compose.yml`.

## Conclusion

Dans cette démo, nous avons exploité le Spring Docker Support pour faciliter le déploiement de notre application de gestion de réservations hôtelières. En utilisant Docker Compose, nous avons pu gérer automatiquement les dépendances et lancer notre application ainsi que la base de données PostgreSQL et pgAdmin sans configuration manuelle fastidieuse. Cela rend le processus de déploiement beaucoup plus simple et efficace.

N'hésitez pas à explorer le code source de l'application et le fichier `docker-compose.yml` pour mieux comprendre comment tout cela fonctionne ensemble. Happy coding!
