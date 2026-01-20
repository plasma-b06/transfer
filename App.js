import React, { Component } from 'react';
import {View,Button,Text,ScrollView} from 'react-native';

const Todo = (props) => (
    <View style={{flexDirection: 'row', alignItems: 'center'}}>
      <Button onPress={props.onCheck} title={props.todo.checked ? "✓" : "✗"}/>
      <Button onPress={props.onDelete} title="delete"/>
      <Text>{props.todo.text}</Text>
    </View>
  );


let count = 0;

export default class App extends React.Component {
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
      })
    });
  }

  addTodo() {
    count++;
    const text = `TODO ${count}`;
    this.setState({
      todos: [...this.state.todos, {text : text, checked: false, id: count }]
    });
  }
    render(){
    return (
      <View>
        <Text>TODO Count: {this.state.todos.length}</Text>
        <Text>Unchecked TODO: {this.state.todos.filter( todo => !todo.checked).lenght}</Text>
        <Button onPress={() => this.addTodo()} title="Add Todo"/>
        <ScrollView>
          {this.state.todos.map(todo => <Todo todo={todo}
              onDelete={ () => this.deleteTodo(todo.id)}
              onCheck={ () => this.toggleTodo(todo.id)}
          />)} 
        </ScrollView>
      </View>
    )}
}
