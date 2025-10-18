# IT Agency Software

Oprogramowanie do zarządzania agencją IT, którego głównym celem jest usprawnienie obsługi klientów, projektów i pracowników w firmie świadczącej usługi informatyczne.

### Aplikacja będzie umożliwiać m.in.:

Rejestrowanie i zarządzanie klientami.
Obsługę projektów IT (tworzenie projektów, śledzenie postępów, terminy).

### Planowane klasy:

<strong>User</strong> - reprezentuje użytkowników systemu (klient, pracownik).</br>
<strong>Client</strong> - przechowuje dane klientów agencji IT.</br>
<strong>Project</strong> - opisuje projekty realizowane dla klientów (terminy, status).</br>
<strong>Employee</strong> - dane pracowników i ich role.</br>
<strong>Task</strong> - klasa reprezentująca zadania w projektach.</br>
<strong>AgencyManagementSystem</strong> - klasa główna zarządzająca całą logiką aplikacji.

### Planowane metody w klasach:

#### User:

-   login() <br>
    Weryfikuje dane logowania użytkownika. Sprawdza, czy email i hasło są poprawne

-   getProfileInfo()<br>
    Zwraca podstawowe informacje o użytkowniku (e-mail, rola, numer telefonu) w formacie tekstowym lub obiektowym.

#### Client:

-   showDashboard(Project project)<br>
    Wyświetla listę dostępnych instukcji, które klient może wykonać po wybraniu odpowiedniej pozycji.

-   updateContactInfo(String newPhone)<br>
    Umożliwia aktualizację danych kontaktowych klienta.

#### Project:

-   updateStatus(String newStatus) <br>
    Aktualizuje status projektu (np. Planned, In Progress, Completed, On Hold), co pozwala śledzić jego bieżący etap realizacji.

#### Employee:

-   showDashboard(Project project)<br>
    Wyświetla listę dostępnych instukcji, które pracownik może wykonać po wybraniu odpowiedniej pozycji.

#### Task:

-   updateStatus(String newStatus) <br>
    Zmienia status zadania (np. To Do, In Progress, Done), co pozwala śledzić postępy pracy.

-   setDeadline(LocalDate deadline) <br>
    Ustawia lub aktualizuje termin wykonania zadania.

#### AgencyManagementSystem:

-   addClient(Client client) <br>
    Dodaje nowego klienta do systemu wraz z jego danymi kontaktowymi.

-   addProject(Project project) <br>
    Tworzy nowy projekt.

-   addEmployee(Employee employee) <br>
    Rejestruje nowego pracownika w systemie i udostępnia jego dane w bazie.

-   setProjectStatus(String projectName) <br>
    Aktualizuje status projektu.

-   setTaskStatus(String projectName) <br>
    Aktualizuje status zadania.

-   addTask(Task task) <br>
    Tworzy nowe zadanie i automatycznie przypisuje.

-   deleteTask(String taskName) <br>
    Tworzy nowe zadanie i automatycznie przypisuje.

-   getProjects(Scanner scanner) <br>
    Zwraca wszystkie projekty

-   getTasks(String projectName) <br>
    Zwraca wszystkie zadania konkretnego projektu

-   getEmployees() <br>
    Zwraca wszystkich pracowników

<!-- ui instrukcji przeniś do odpowiednich klas, które będą wywoływać sktypy do plików -->

<!-- zamień closeProject i closeTask na setStatus -->
