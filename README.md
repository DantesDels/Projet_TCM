# 🛒 Projet TCM - E-Commerce Console App

Ce projet est une application de gestion de vente de vêtements en ligne de commande. Il implémente une architecture 
modulaire respectant les principes de la **Programmation Orientée Objet** et les **Design Patterns** requis par 
la grille d'évaluation.

---

## 🚀 Lancement rapide avec IntelliJ IDEA

Puisque le projet est structuré pour **IntelliJ IDEA**, vous n'avez pas besoin d'utiliser le terminal pour compiler ou lancer l'application. L'IDE gère automatiquement le cycle de vie du projet.

### Lancer l'application :

1. **Localiser le point d'entrée** : Dans l'explorateur de projet (à gauche), naviguez vers le dossier `src/cli/`.
2. **Exécuter la classe principale** : Faites un **clic droit** sur le fichier `ConsoleApp.java`.
3. **Lancer** : Sélectionnez l'option **Run 'ConsoleApp.main()'** dans le menu contextuel.
4. **Utilisation** : L'interface en ligne de commande s'ouvrira directement dans l'onglet **Run** en bas de votre IDE.

> **Note :** IntelliJ s'occupe de la compilation automatique vers le dossier `out/`. Si vous rencontrez des erreurs de symboles non reconnus, faites `Build > Rebuild Project` (situé dans les onglets en bas à gauche de l'IDE IntelliJ).

---

### 🗓️ Suivi Weekly Reset
- [x] **Documentation** : Ajout de la procédure de lancement simplifiée via IntelliJ.
- [x] **Environnement** : Validation du dossier `src` comme racine des sources.
- [ ] **Test** : Vérifier que le catalogue s'affiche correctement dans la console de l'IDE.
---
## 📂 Structure du Projet (Packages)

L'organisation des fichiers suit une séparation stricte des responsabilités :
* **`cli`** : Interface utilisateur, contenant le `ConsoleApp`, le `MenuHandler` et les commandes.
* **`core`** : Contrats et interfaces de base (`Command`, `DiscountStrategy`).
* **`factory`** : Logique de création (`ProductFactory`, `UserBuilder`).
* **`models`** : Entités métier (Héritage `BaseEntity`, `Product`, `User`) et pattern **Decorator**.
* **`repository`** : Persistance en mémoire via `InMemoryProductRepo` et `InMemoryUserRepo`.
* **`services`** : Traitements transverses comme `OrderService`.
* **`util`** : Initialisation des données via `SeedData`.

---

## ⚖️ Validation des principes POO & SOLID

Ce projet a été conçu pour respecter les standards de qualité logicielle les plus élevés, en appliquant les principes **SOLID** pour garantir un code modulaire et évolutif.

### 🏗️ Fondamentaux de la POO

| Concept | Preuve dans le code |
| :--- | :--- |
| **Héritage** | Utilisation d'une hiérarchie à trois niveaux : `BaseEntity` (gestion des UUID) -> `Product` (classe parente) -> `Clothing` (classe concrète instanciée). |
| **Polymorphisme** | Dans `ShowCatalogueCommand`, l'appel `p.display()` exécute dynamiquement la méthode appropriée, que l'objet soit un produit simple ou un produit décoré d'une promotion. |
| **Abstraction** | Les classes `Product` et `ProductDecorator` sont marquées `abstract` pour définir un contrat strict et empêcher l'instanciation d'objets incohérents. |
| **Encapsulation** | Les attributs `name` et `price` sont protégés (accès via getters/setters), garantissant que l'état interne des objets n'est pas modifié de manière directe. |

### 🛡️ Principes SOLID

| Principe | Application Concrète dans le Code |
| :--- | :--- |
| **S - Single Responsibility** | Chaque classe possède une responsabilité unique : le `UserBuilder` s'occupe de la création d'utilisateurs, les `Commands` (ex: `AddProductCommand`) gèrent les actions du menu, et les `InMemoryRepos` gèrent le stockage. |
| **O - Open/Closed** | Le système est **fermé à la modification** (on ne touche plus à `Product.java`) mais **ouvert à l'extension** : l'ajout d'une promotion via le `DiscountDecorator` se fait sans modifier le code existant. |
| **L - Liskov Substitution** | Le `DiscountDecorator` hérite de `ProductDecorator`, lui-même héritant de `Product`. Il peut donc remplacer n'importe quel produit dans le catalogue ou le panier sans altérer le comportement global. |
| **I - Interface Segregation** | L'interface `Command` dans le package `core` est minimaliste (une seule méthode `execute()`). Les classes qui l'implémentent ne sont pas forcées de définir des méthodes dont elles n'ont pas besoin. |
| **D - Dependency Inversion** | Les classes de haut niveau (dans `cli.commands`) dépendent des interfaces (dans `repository.ProductRepository`) et non des implémentations concrètes. Cela facilite le passage à une base de données réelle. |

---

## 🛠️ Design Patterns Implémentés

### 1. Patterns de Création
* **UserBuilder** : Permet la construction fluide des utilisateurs avec des rôles par défaut (ex: `CLIENT`).
* **ProductFactory** : Centralise l'instanciation des objets pour isoler la logique de création.

### 2. Pattern de Structure
* **Decorator** : Implémenté via `DiscountDecorator`. Il permet d'ajouter dynamiquement des badges de promotion au catalogue sans modifier la classe de base `Product`.

### 3. Pattern de Comportement
* **Command** : Chaque action (ex: `AddProductCommand`, `ShowCatalogueCommand`) est encapsulée, découplant le menu de la logique métier.

---

## ⚙️ Correction de l'affichage
Pour corriger l'affichage décalé constaté dans le catalogue, les méthodes ont été ajustées ainsi :

1. **Dans `Product.java`** : La méthode `display(String indent)` utilise `System.out.print` au lieu de `println` pour maintenir le curseur sur la ligne.
2. **Dans `DiscountDecorator.java`** : La méthode appelle `decoratedProduct.display()` puis ajoute le badge promo sur la même ligne avant de conclure par un `println`.

---

## 🗺️ Roadmap de Développement

### Phase 1 : Consolidation Métier (Court terme)
* **Calcul de prix dynamique** : Intégrer la réduction mathématique dans `DiscountDecorator.getPrice()`.
* **Sécurité & Rôles** : Restreindre l'accès à `AddProductCommand` aux seuls utilisateurs `ADMIN`.

### Phase 2 : Persistance & Données (Moyen terme)
* **Format JSON** : Implémenter un `JsonProductRepository` pour sauvegarder les données sur le disque.
* **Gestion du chargement** : Support de l'ID existant dans `BaseEntity` lors de la désérialisation.

### Phase 3 : Qualité (Finalisation)
* **Diagramme UML** : Générer la vue technique de l'architecture pour expliquer aux clients.
* **Gestion d'erreurs** : Remplacer les sorties brutales par une gestion d'exceptions (`try-catch`).

---