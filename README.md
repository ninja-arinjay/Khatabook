# Khatabook - Expense Tracker

Khatabook is a simple Spring Boot application designed to help users manage their expenses efficiently. It allows users to add, update, delete, and view expenses, as well as set monthly budgets and receive warnings when their spending exceeds the set limits.

## Features

- **Add Expense:** Users can add an expense with a description, amount, and category.
- **Update Expense:** Users can update an existing expense.
- **Delete Expense:** Users can delete an expense.
- **View All Expenses:** Users can view a list of all expenses.
- **Expense Summary:** Users can view a summary of all expenses.
- **Monthly Summary:** Users can view a summary of expenses for a specific month (current year).
- **Filter by Category:** Users can filter expenses by category.
- **Set Monthly Budget:** Users can set a budget for each month and receive warnings when they exceed it.

## Technologies Used

- **Spring Boot** - Backend framework
- **MySQL Database** - database for testing
- **Maven** - Dependency management
- **Postman** - API testing

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/khatabook.git
   cd khatabook
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application:**
   The application will run at `http://localhost:8080`

### API Endpoints

| Method | Endpoint                        | Description                          |
|--------|---------------------------------|--------------------------------------|
| GET    | `/expenses`                    | View all expenses                    |
| GET    | `/expenses/category/{category}`| View expenses filtered by category   |
| GET    | `/expenses/summary`            | Get a summary of all expenses        |
| GET    | `/expenses/summary/{month}`    | Get a summary for a specific month   |
| POST   | `/expenses`                    | Add a new expense                    |
| PUT    | `/expenses/{id}`               | Update an expense by ID              |
| DELETE | `/expenses/{id}`               | Delete an expense by ID              |
| POST   | `/budget`                      | Set a budget for a month             |

### Example API Requests

**Add an Expense:**
```json
POST http://localhost:8080/expenses
{
    "description": "Office supplies",
    "amount": 500,
    "category": "Work"
}
```

**Set a Budget:**
```json
POST http://localhost:8080/budget
{
    "month": "2",
    "maxLimit": 2000
}
```

**Update an Expense:**
```json
PUT http://localhost:8080/expenses/4
{
    "description": "Updated description",
    "amount": 900,
    "category": "Updated category"
}
```

**Delete an Expense:**
```json
DELETE http://localhost:8080/expenses/6
```


**Successful Expense Addition with Budget Warning:**
```json
{
    "success": true,
    "warning": true,
    "message": "Max Limit Reached"
}
```

**Successful Expense Addition within Budget:**
```json
{
    "success": true,
    "warning": false,
    "message": "You are within the limit"
}
```

## Contributing

1. Fork the repository.
2. Create your feature branch: `git checkout -b feature/new-feature`
3. Commit your changes: `git commit -m 'Add new feature'`
4. Push to the branch: `git push origin feature/new-feature`
5. Open a pull request.

## License

This project is licensed under the MIT License.

---

Happy coding! 😊
Reference for project: https://roadmap.sh/projects/expense-tracker-api


