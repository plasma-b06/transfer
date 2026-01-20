import React from 'react';
import { render } from 'react-dom';


const Todo = (props) => {
  return (
    <li>
      <input type="checkbox" checked={props.todo.checked} onChange={props.onCheck} />
      <button onClick={props.onDelete}>Delete</button>
      <span >{props.todo.text}</span>
    </li>
  );
};

let count = 0;

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      todos: []
    };
  }

  deleteTodo(index) {
    this.setState({
      todos: this.state.todos.filter(todo => todo.id !== index)
    });
  }

  toggleTodo(index) {
    this.setState({
      todos: this.state.todos.filter( 
        todo =>{ if(todo.id !== index) return todo;
        return {
          id: todo.id,
          text: todo.text,
          checked: !todo.checked,
        }
      )};
    });
  }

  addTodo() {
    const text = prompt("What needs to be done?");
    this.setState({
      todos: [...this.state.todos, {text : text, checked: false, id: count++ }]
    });
  }

    return (
      <div >
        <div> TODO Count: {this.state.todos.length}</div>
        <div> Unchecked TODO: {this.state.todos.filter( todo => !todo.checked).lenght}</div>
        <button onClick={ () => this.addTodo() }>Add Todo</button>
        <ul>
          {this,state.todos.map(todo => <Todo todo={todo}
              onDelete={ () => this.deleteTodo(todo.id)}
              onCheck={ () => this.toggleTodo(todo.id)}
          />)} 
        </ul>
      </div>
    );
}

render(<App /> , document.getElementById('root'));
