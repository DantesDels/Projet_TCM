# Projet_TCM
Personal project for Advanced POO

### 📁 src/main/java/com/shop
#### 📦 core (Interfaces et abstractions)
- `ShopItem.java` : Interface commune (Composite) pour Product et Collection.
- `Command.java` : Interface pour le Pattern Command (Menu CLI).
- `DiscountStrategy.java` : Interface pour les promotions (Strategy).

#### 📦 models (Données)
- `Product.java` : Classe de base (T-shirt, Pantalon) avec equals/hashCode.
- `ClothingCollection.java` : Le Composite (liste de ShopItem).
- `User.java` : Modèle utilisateur avec son ShoppingCart.
- `ShoppingCart.java` : Gestion de la Map<ShopItem, Integer>.

#### 📦 factory (Pattern de Création)
- `ClothingFactory.java` : Méthode static pour créer les produits.
- `UserBuilder.java` : Builder fluide pour la création d'utilisateurs.

#### 📦 repository (Stockage en mémoire)
- `ProductRepository.java` : Stocke la liste des produits/collections dispos.
- `UserRepository.java` : Stocke les comptes clients créés.

#### 📦 services (Logique métier - SRP)
- `AuthService.java` : Inscription et connexion.
- `OrderService.java` : Validation du panier et calcul du prix total.

#### 📦 cli (Interface utilisateur - Command Pattern)
- `ConsoleApp.java` : Le point d'entrée (Main).
- `MenuHandler.java` : Affiche les menus et exécute les commandes.
##### 📂 commands (Implémentations des actions)
- `AddProductCommand.java` (Admin)
- `CreateCollectionCommand.java` (Admin)
- `LoginCommand.java` (Client)
- `AddToCartCommand.java` (Client)


### 📁 src/main/java/com/shop

#### 📦 core (Abstractions & Contrats)
- `ShopItem.java`           | **Interface** | Composant de base du pattern Composite.
- `Command.java`            | **Interface** | Contrat pour les actions du menu (Pattern Command).
- `DiscountStrategy.java`   | **Interface** | Contrat pour le calcul des remises (Pattern Strategy).

#### 📦 models (Objets de données)
- `Product.java`            | **Classe** | Implémente `ShopItem`. Gère `equals()`/`hashCode()`.
- `ClothingCollection.java` | **Classe** | Le Composite. Liste récursive de `ShopItem`.
- `User.java`               | **Classe** | Modèle utilisateur (inclut le `UserBuilder`).
- `ShoppingCart.java`       | **Classe** | Gestion du panier (`Map<ShopItem, Integer>`).
- `UserRole.java`           | **Enum** | Définit les rôles : `ADMIN`, `CLIENT`.

#### 📦 factory (Patterns de Création)
- `ClothingFactory.java`    | **Classe** | Création centralisée via méthode `static`.
- `UserBuilder.java`        | **Classe** | Pattern Builder pour l'instanciation de `User`.

#### 📦 repository (Accès aux données)
- `ProductRepository.java`  | **Interface** | Abstraction du stockage des produits.
- `InMemoryProductRepo.java`| **Classe** | Implémentation concrète du stockage en mémoire.
- `UserRepository.java`     | **Interface** | Abstraction du stockage des utilisateurs.

#### 📦 services (Logique métier - SRP)
- `AuthService.java`        | **Interface** | Contrat pour la sécurité et l'accès.
- `AuthServiceImpl.java`    | **Classe** | Implémentation de la logique de connexion.
- `OrderService.java`       | **Classe** | Service de traitement des commandes.

#### 📦 cli (Interface Utilisateur)
- `ConsoleApp.java`         | **Classe** | Point d'entrée (`main`) de l'application.
- `MenuHandler.java`        | **Classe** | Orchestrateur des menus et des commandes.
- **📂 commands** (Implémentations du Pattern Command)
    - `AddProductCommand.java`       | **Classe** | Action Admin : Ajout au stock.
    - `CreateCollectionCommand.java`  | **Classe** | Action Admin : Création de pack.
    - `LoginCommand.java`            | **Classe** | Action Commune : Authentification.
    - `AddToCartCommand.java`        | **Classe** | Action Client : Achat de produits.