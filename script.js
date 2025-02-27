let employeeVitrinsMap = {};

async function fetchEmployees() {
    const response = await fetch('http://localhost:9090/users');
    const employees = await response.json();
    const sidebar = document.querySelector('.sidebar');
    sidebar.innerHTML = '';

    employees.forEach(employee => {
        const employeeContainer = document.createElement('div');
        employeeContainer.className = 'employee-container';
        const div = document.createElement('div');
        div.className = 'employee';
        div.textContent = `👤 ${employee.firstName} ${employee.lastName}`;
        div.setAttribute('data-employee-id', employee.id);
        div.addEventListener('click', async () => {
            let showcaseWrapper = employeeContainer.querySelector('.showcase-wrapper');
            if (showcaseWrapper) {
                showcaseWrapper.classList.remove('open');
                setTimeout(() => showcaseWrapper.remove(), 400);
            } else {
                const response = await fetch(`http://localhost:9090/user/${employee.id}`);
                const employeeDetails = await response.json();
                showcaseWrapper = document.createElement('div');
                showcaseWrapper.className = 'showcase-wrapper';
                const showcaseDiv = document.createElement('div');
                showcaseDiv.className = 'showcase';
                showcaseDiv.innerHTML = employeeDetails.vitrins.length > 0
                    ? employeeDetails.vitrins.map(vitrin => `<div class="showcase-box"><strong>${vitrin.name}</strong></div>`).join('')
                    : '<p>У сотрудника нет закреплённых витрин.</p>';
                showcaseWrapper.appendChild(showcaseDiv);
                employeeContainer.appendChild(showcaseWrapper);
                setTimeout(() => showcaseWrapper.classList.add('open'), 10);
            }
            highlightVitrinsForEmployee(employee.id);
        });
        employeeContainer.appendChild(div);
        sidebar.appendChild(employeeContainer);

        employeeVitrinsMap[employee.id] = employee.vitrins ? employee.vitrins.map(v => v.id) : [];
    });
}

async function fetchVitrins() {
    const response = await fetch('http://localhost:9090/vitrins');
    const vitrins = await response.json();
    const rightBlock = document.querySelector('.right-block');
    rightBlock.innerHTML = '';
    vitrins.forEach(vitrin => {
        const div = document.createElement('div');
        div.className = 'rectangle';
        div.style.top = `${vitrin.y}px`;
        div.style.left = `${vitrin.x}px`;
        div.style.width = `${vitrin.width}px`;
        div.style.height = `${vitrin.height}px`;
        div.setAttribute('data-name', vitrin.name);
        div.setAttribute('data-id', vitrin.id);
        div.addEventListener('click', (e) => {
            e.stopPropagation();
            showVitrinMenu(div, vitrin.id);
        });
        rightBlock.appendChild(div);
    });
}

function highlightVitrinsForEmployee(employeeId) {
    document.querySelectorAll('.rectangle').forEach(rectangle => {
        rectangle.classList.remove('highlight');
    });

    const vitrinIds = employeeVitrinsMap[employeeId];
    vitrinIds.forEach(id => {
        const rectangle = document.querySelector(`.rectangle[data-id='${id}']`);
        if (rectangle) {
            rectangle.classList.add('highlight');
        }
    });
}

let currentVitrinId = null;

function showVitrinMenu(vitrinId) {
    const vitrinActions = document.querySelector('.vitrin-actions');
    const editItem = vitrinActions.querySelector('.edit-vitrin');
    const taskItem = vitrinActions.querySelector('.create-task');

    // Обновляем действия для кнопок
    editItem.onclick = () => {
        alert(`Редактирование витрины с ID: ${vitrinId}`);
    };
    taskItem.onclick = () => {
        alert(`Создание задачи для витрины с ID: ${vitrinId}`);
    };

    // Показываем блок
    vitrinActions.style.display = 'block';
    currentVitrinId = vitrinId;
}

// Скрытие блока при клике вне его
document.addEventListener('click', (e) => {
    const vitrinActions = document.querySelector('.vitrin-actions');
    if (!vitrinActions.contains(e.target) && !e.target.classList.contains('rectangle')) {
        vitrinActions.style.display = 'none';
        currentVitrinId = null;
    }
});

document.addEventListener('DOMContentLoaded', () => {
    fetchEmployees();
    fetchVitrins();

    const avatarContainer = document.querySelector('.avatar-container');
    const popupMenu = document.querySelector('.popup-menu');

    avatarContainer.addEventListener('mouseenter', () => {
        popupMenu.classList.add('active');
    });

    avatarContainer.addEventListener('mouseleave', () => {
        popupMenu.classList.remove('active');
    });

    popupMenu.querySelector('.settings').addEventListener('mouseenter', function() {
        this.style.backgroundColor = '#FFA500';
    });
    popupMenu.querySelector('.settings').addEventListener('mouseleave', function() {
        this.style.backgroundColor = '';
    });
    popupMenu.querySelector('.logout').addEventListener('mouseenter', function() {
        this.style.backgroundColor = '#FF6347';
    });
    popupMenu.querySelector('.logout').addEventListener('mouseleave', function() {
        this.style.backgroundColor = '';
    });
});