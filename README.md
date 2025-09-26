# IT Agency Software

Oprogramowanie do zarządzania agencją IT, którego głównym celem jest usprawnienie obsługi klientów, projektów i pracowników w firmie świadczącej usługi informatyczne.

### Aplikacja będzie umożliwiać m.in.:

Rejestrowanie i zarządzanie klientami (dane kontaktowe, historia współpracy, status aktywności).
Obsługę projektów IT (tworzenie projektów, przypisywanie zespołów, śledzenie postępów, terminy i budżety).
Zarządzanie pracownikami (stanowiska, umiejętności, przypisanie do projektów).
Generowanie raportów i podsumowań (np. lista aktywnych projektów, obciążenie pracowników).

### Planowane klasy:

<strong>User</strong> - reprezentuje użytkowników systemu (administrator, project manager, pracownik).</br>
<strong>Client</strong> - przechowuje dane klientów agencji IT.</br>
<strong>Project</strong> - opisuje projekty realizowane dla klientów (terminy, status, budżet).</br>
<strong>Employee</strong> - dane pracowników, ich role i przypisania do projektów.</br>
<strong>Task</strong> - opcjonalna klasa reprezentująca zadania w projektach.</br>
<strong>AgencyManagementSystem</strong> - klasa główna zarządzająca całą logiką aplikacji.

<!-- <strong>ReportGenerator</strong> - odpowiedzialna za generowanie zestawień i raportów.</br> -->

### Planowane metody w klasach:

#### User:

-   login(String email, String password) <br>
    Weryfikuje dane logowania użytkownika. Sprawdza, czy email i hasło są poprawne

-   logout()<br>
    Wylogowuje aktualnego użytkownika.

-   getUserInfo()<br>
    Zwraca podstawowe informacje o użytkowniku (np. ID, imię, e-mail, rola) w formacie tekstowym lub obiektowym.

-   hasPermission(String action)<br>
    Sprawdza, czy użytkownik ma odpowiednie uprawnienia do wykonania określonej akcji (np. dodanie projektu

#### Client:

-   getClientSummary()<br>
    Zwraca podsumowanie najważniejszych informacji o kliencie, takich jak nazwa firmy, liczba aktywnych projektów, status współpracy.

-   addProject(Project project)<br>
    Dodaje nowy projekt powiązany z danym klientem do jego listy projektów.

-   updateContactInfo(String newEmail, String newPhone)<br>
    Umożliwia aktualizację danych kontaktowych klienta (adres e-mail, numer telefonu).

#### Project:

-   updateStatus(String newStatus) <br>
    Aktualizuje status projektu (np. Planned, In Progress, Completed, On Hold), co pozwala śledzić jego bieżący etap realizacji.

-   adjustBudget(double newBudget) <br>
    Umożliwia zmianę lub korektę budżetu projektu w przypadku nowych ustaleń z klientem.

-   assignEmployee(Employee employee) <br>
    Przypisuje pracownika do projektu, dodając go do listy członków zespołu projektowego.

-   getProjectSummary() <br>
    Zwraca zestawienie kluczowych informacji o projekcie, takich jak nazwa, termin rozpoczęcia i zakończenia, status oraz aktualny budżet.

#### Employee:

-   assignToProject(Project project) <br>
    Dodaje pracownika do wybranego projektu i zapisuje jego udział w realizacji.

-   updateRole(String newRole) <br>
    Umożliwia zmianę roli pracownika w firmie lub w konkretnym projekcie (np. z Developer na Team Lead).

-   getEmployeeInfo() <br>
    Zwraca dane osobowe i zawodowe pracownika, w tym imię, nazwisko, stanowisko, przypisane projekty oraz kluczowe umiejętności.

-   removeFromProject(Project project) <br>
    Usuwa pracownika z listy członków danego projektu, np. po jego zakończeniu lub zmianie zespołu.

#### Task:

-   updateStatus(String newStatus) <br>
    Zmienia status zadania (np. To Do, In Progress, Done), co pozwala śledzić postępy pracy.

-   assignEmployee(Employee employee) <br>
    Przypisuje konkretnego pracownika do realizacji danego zadania.

-   setDeadline(LocalDate deadline) <br>
    Ustawia lub aktualizuje termin wykonania zadania.

-   getTaskDetails() <br>
    Zwraca opis zadania wraz z informacjami o przypisanym pracowniku, terminie i aktualnym statusie.

<!-- #### ReportGenerator:

-   generateProjectReport(Project project) <br>
    Tworzy szczegółowy raport dotyczący postępów, kosztów i statusu wybranego projektu.

-   generateEmployeeReport(Employee employee) <br>
    Generuje raport pracy danego pracownika, zawierający informacje o jego zaangażowaniu i wykonanych zadaniach.

-   generateClientSummary(Client client) <br>
    Przygotowuje raport podsumowujący współpracę z konkretnym klientem (liczba projektów, aktualny status, budżety).

-   exportReport(String format) <br>
    Eksportuje wybrany raport w określonym formacie (np. PDF, CSV, DOCX). -->

#### AgencyManagementSystem:

-   addClient(Client client) <br>
    Dodaje nowego klienta do systemu wraz z jego danymi kontaktowymi.

-   createProject(Client client, Project project) <br>
    Tworzy nowy projekt i automatycznie przypisuje go do wybranego klienta.

-   addEmployee(Employee employee) <br>
    Rejestruje nowego pracownika w systemie i udostępnia jego dane w bazie.

-   findProjectById(int projectId) <br>
    Wyszukuje projekt w systemie na podstawie unikalnego identyfikatora.

-   generateReports() <br>
    Wywołuje proces tworzenia raportów zbiorczych, np. listy aktywnych projektów lub dostępnych pracowników.
