# Projet_TCM
Personal project for Advanced POO

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

## ⚖️ Gestion des Quantités et Responsabilités

Une attention particulière a été portée à la séparation entre la **définition d'un produit** et son **usage dans un panier**.

### 1. Pourquoi la quantité n'est pas dans l'interface `ShopItem` ?
Conformément aux principes **SOLID**, l'interface `ShopItem` (Pattern Composite) ne contient pas de méthode `getQuantity()`.
- **Principe ISP (Interface Segregation) :** Un produit du catalogue n'a pas besoin de connaître une quantité d'achat pour définir son prix ou son nom.
- **Principe SRP (Single Responsibility) :** La responsabilité de suivre le volume d'achat incombe au panier (`ShoppingCart`), et non au modèle de données (`Product`).

### 2. Implémentation technique via `Map`
La gestion des quantités est centralisée dans la classe `ShoppingCart` en utilisant une structure de données `Map<ShopItem, Integer>`.

| Composant | Rôle |
| :--- | :--- |
| **Clé (`ShopItem`)** | L'objet unique (Produit ou Collection) identifié par son `equals()` et `hashCode()`. |
| **Valeur (`Integer`)** | Le multiplicateur représentant la quantité saisie par l'utilisateur. |

#### Exemple de logique de calcul :
```java
public double calculateTotal() {
    return items.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
}