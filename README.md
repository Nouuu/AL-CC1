| [![wakatime](https://wakatime.com/badge/user/3106fbc8-c1fe-4d47-b9ce-b0514ce3fb3d/project/19997bda-72d3-4311-b5b1-f9552652206a.svg)](https://wakatime.com/badge/user/3106fbc8-c1fe-4d47-b9ce-b0514ce3fb3d/project/19997bda-72d3-4311-b5b1-f9552652206a) |
| ------------------------------------------------------------ |

# Architecture choisie

## Domain-Driven Design

Cette application a été conçu en utilisant une approche DDD (Domain-Driven Design). Cela fit référence à une conception piloté par le métier. De cette manière, l'application est séparée en 2 package principaux :

- **Domain :** Contient l'ensemble des informations relatives au métier.
- **Infrastructure :** Contient les implémentations des différentes interfaces, se comporte comme une bibliothèque de support au domaine

## Implémentation

### API

strategy

### Entités

Value object design + entity

### Événements

Observable, event

### Exception

### Logger

factory, strategy

### Repositories

pattern repository, strategy

### Services

interfaces, polymorphisme, DI
