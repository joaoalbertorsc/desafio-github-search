# GitHub Search Challenge

This project is an Android application developed as part of the GitHub Search Challenge. The app allows users to search for a GitHub user and view a list of their public repositories.

This project is a challenge from the **Cognizant - Mobile Developer** bootcamp on the **DIO** platform.

![image](https://user-images.githubusercontent.com/5827265/188474294-4472bcc0-24ee-4ccd-80a8-7cee0372e7fa.png)

## About the Project

The goal was to build a simple yet functional Android app that demonstrates key development concepts. The app features a main screen where a user can input a GitHub username. Upon confirmation, the app fetches and displays a list of that user's public repositories. The last searched username is saved and pre-filled when the app restarts.

## Features Implemented

- **User Input:** An `EditText` field for users to enter a GitHub username.
- **Data Fetching:** Asynchronously fetches repository data from the official GitHub API.
- **Data Display:** Uses a `RecyclerView` to efficiently display the list of repositories.
- **Data Persistence:** Saves the last searched username using `SharedPreferences`, providing a more seamless user experience on subsequent uses.
- **Interactivity:**
    - Tapping on a repository item opens the repository's URL in a web browser.
    - A share button on each item allows the user to share the repository's URL through other apps.
- **Error Handling:** Displays a `Toast` message for network errors or unsuccessful API responses.

## Technologies and Libraries Used

- **IDE:** Android Studio
- **Language:** Kotlin
- **Core Components:**
    - `AppCompatActivity` for backward compatibility.
    - `RecyclerView` and `CardView` for creating a modern, scrollable list.
    - `ConstraintLayout` for building a flexible and responsive UI.
- **Networking:**
    - **Retrofit:** A type-safe HTTP client for making network requests to the GitHub API.
    - **Gson:** A library for converting JSON data from the API into Kotlin data classes.
- **Data Storage:**
    - **SharedPreferences:** Used for simple, persistent storage of the username.

---

# Desafio GitHub Search 🇧🇷

Este projeto é uma aplicação Android desenvolvida como parte do Desafio GitHub Search. O aplicativo permite que os usuários pesquisem por um usuário do GitHub e vejam uma lista de seus repositórios públicos.

Este projeto é um desafio do bootcamp **Cognizant - Mobile Developer** da plataforma **DIO**.

![image](https://user-images.githubusercontent.com/5827265/188474294-4472bcc0-24ee-4ccd-80a8-7cee0372e7fa.png)

## Sobre o Projeto

O objetivo foi construir um aplicativo Android simples, mas funcional, que demonstra conceitos-chave de desenvolvimento. O app possui uma tela principal onde o usuário pode inserir um nome de usuário do GitHub. Após a confirmação, o aplicativo busca e exibe uma lista dos repositórios públicos desse usuário. O último nome de usuário pesquisado é salvo e preenchido automaticamente quando o aplicativo é reiniciado.

## Funcionalidades Implementadas

- **Entrada de Usuário:** Um campo `EditText` para que os usuários insiram um nome de usuário do GitHub.
- **Busca de Dados:** Busca os dados dos repositórios de forma assíncrona da API oficial do GitHub.
- **Exibição de Dados:** Utiliza uma `RecyclerView` para exibir a lista de repositórios de forma eficiente.
- **Persistência de Dados:** Salva o último nome de usuário pesquisado usando `SharedPreferences`, proporcionando uma experiência de usuário mais fluida em usos subsequentes.
- **Interatividade:**
    - Tocar em um item de repositório abre a URL do repositório em um navegador da web.
    - Um botão de compartilhamento em cada item permite ao usuário compartilhar a URL do repositório através de outros aplicativos.
- **Tratamento de Erros:** Exibe uma mensagem de `Toast` para erros de rede ou respostas da API sem sucesso.

## Tecnologias e Bibliotecas Utilizadas

- **IDE:** Android Studio
- **Linguagem:** Kotlin
- **Componentes Principais:**
    - `AppCompatActivity` para retrocompatibilidade.
    - `RecyclerView` e `CardView` para criar uma lista rolável e moderna.
    - `ConstraintLayout` para construir uma UI flexível e responsiva.
- **Rede (Networking):**
    - **Retrofit:** Um cliente HTTP type-safe para fazer requisições de rede para a API do GitHub.
    - **Gson:** Uma biblioteca para converter os dados JSON da API em data classes do Kotlin.
- **Armazenamento de Dados:**
    - **SharedPreferences:** Usado para armazenamento persistente e simples do nome de usuário.
