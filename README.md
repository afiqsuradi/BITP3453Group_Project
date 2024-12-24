# Lab Inventory Management App - Developer Guide

<br/>

This document provides a guide for my team members on how to perform CRUD (Create, Read, Update, Delete) operations using ViewModels and Room in our Android application.

<br/>

## Table of Contents
1. [Project Structure](#project-structure)
2. [Key Concepts](#key-concepts)
3. [Performing CRUD Operations using ViewModels](#performing-crud-operations-using-viewmodels)
     * [Get ViewModel instance](#get-viewmodel-instance)
     * [CRUD Operations](#crud-operations)
        * [Create](#create)
        * [Update](#update)
        * [Delete](#delete)
        * [Read](#read)

## Project Structure

<br/>

Our application is structured using the following layers:

<br/>

*   **Data Layer:** Handles data access and storage (Room database, entities, repositories).
    *   `data/db`: Database-related code (Room setup, DAOs).
    *   `data/repository`: Repository interfaces for data access.
    *   `data/model`: Data model classes (entities).
    *   `data/util`: Data util to perform export and import.
*   **UI Layer:** Contains Activities, Fragments, Layouts, and Adapters responsible for the user interface.
    *   `ui/lab`: UI components related to lab management.
    *   `ui/item`: UI components related to item management.
*   **ViewModel Layer:** Manages data for UI components and handles business logic.
    *   `viewmodel`: ViewModels used to access data from the repository and update UI.
*   **Utils Layer:** Helper classes used throughout the app such as SharedPreferences

<br/>

## Key Concepts

<br/>

**Room Database:** Room is an abstraction layer over SQLite that allows to access the database with minimal boiler plate code.<br/>
**Entities:** Classes that represent tables in the database.<br/>
**DAOs:** Data Access Objects that performs CRUD operation. This is where our SQL query is located<br/>
**Converters:** Convert custom types to database compatible types such as Date.<br/>
**Repository:** Class that abstracts data access, can either be from the local database or from the remote API.<br/>
**ViewModel:** Class to manage UI related data, should use repository to fetch data. <br/>
**LiveData:** LiveData is lifecycle aware data holder, it observes change on data and triggers UI to update.<br/>

<br/>

## Performing CRUD Operations using ViewModels
In order for you to use vewmodel, you are going to need to get its instance first
<br/>
### **Get ViewModel instance**
```java
    itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
```

<br/>

### **Observe LiveData**
```java
itemViewModel.getAllItems().observe(this, items -> {
  //Update the adapter here, this will be triggered whenever new data is fetched from database
  itemAdapter.setItems(items);
})
```

<br/>

### **CRUD Operations**
  #### Create
```java
     Item newItem = new Item("New Item", "Description", 1, "Good", System.currentTimeMillis());
     itemViewModel.insert(newItem);
```
  #### Update
```java
    // newItem is the one that we created previously
    newItem.setName("Other Name");
    itemViewModel.update(updatedItem);
```
  #### Delete
```java
    itemViewModel.delete(newItem);
```
  #### Read
```java
    // get specific
    itemViewModel.getAllItemsByLabId(labId);
    // get all
    itemViewModel.getAllItems().observe(this, items -> {
      itemAdapter.setItems(items);
    });
 ```
<br/>
