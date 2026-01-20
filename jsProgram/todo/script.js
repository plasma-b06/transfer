const classNames = {
  TODO_ITEM: 'todo-container',
  TODO_CHECKBOX: 'todo-checkbox',
  TODO_TEXT: 'todo-text',
  TODO_DELETE: 'todo-delete',
}

const list = document.getElementById('todo-list')
const itemCountSpan = document.getElementById('item-count')
const uncheckedCountSpan = document.getElementById('unchecked-count')

function newTodo() {
  itemCountSpan.innerHTML = parseInt(itemCountSpan.innerHTML) + 1;
  uncheckedCountSpan.innerHTML = parseInt(uncheckedCountSpan.innerHTML) + 1;
  list.innerHTML += `
    <div class="${classNames.TODO_ITEM}">
      <input type="checkbox" onCheck=${checkTodo(this.checkbox)} class="${classNames.TODO_CHECKBOX}" />
      <span class="${classNames.TODO_TEXT}">New TODO</span>
      <button onClick=${deleteTodo(this.todo)} class="${classNames.TODO_DELETE}">Delete</button>
    </div>
  `;

  const newItem = list.lastElementChild;
  const checkbox = newItem.querySelector(`.${classNames.TODO_CHECKBOX}`);
  const deleteButton = newItem.querySelector(`.${classNames.TODO_DELETE}`);

  alert('New TODO button clicked!');
}

function checkTodo(checkbox) {
  try {
    const todoItem = checkbox.parentElement;
    const isChecked = checkbox.checked;

    if (isChecked) {
      uncheckedCountSpan.innerHTML = parseInt(uncheckedCountSpan.innerHTML) - 1;
      todoItem.classList.add('checked');
    } else {
      uncheckedCountSpan.innerHTML = parseInt(uncheckedCountSpan.innerHTML) + 1;
      todoItem.classList.remove('checked');
    }
  } catch (error) {
    console.error('Error checking todo:', error);
  }
}

function deleteTodo(todoItem) {
  try {
    const checkbox = todoItem.querySelector(`.${classNames.TODO_CHECKBOX}`);
    if (!checkbox.checked) {
      uncheckedCountSpan.innerHTML = parseInt(uncheckedCountSpan.innerHTML) - 1;
    }
    todoItem.remove();
    list.removeChild(todoItem);
    itemCountSpan.innerHTML = parseInt(itemCountSpan.innerHTML) - 1;
  } catch (error) {
    console.error('Error deleting todo:', error);
  }
}

document.addEventListener('DOMContentLoaded', () => {
  const todoItems = document.querySelectorAll(`.${classNames.TODO_ITEM}`);
  
  todoItems.forEach(item => {
    const checkbox = item.querySelector(`.${classNames.TODO_CHECKBOX}`);
    const deleteButton = item.querySelector(`.${classNames.TODO_DELETE}`);
    
    checkbox.addEventListener('change', () => checkTodo(checkbox));
    deleteButton.addEventListener('click', () => deleteTodo(item));
  });
});
