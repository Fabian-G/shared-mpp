import React, {useMemo, useState} from 'react';
import logo from './logo.svg';
import './App.css';
import aClient from "a-client"
import bClient from "b-client"

const createClientA = aClient.org.example.commonclient.createClient;
const createClientB = bClient.org.example.commonclient.createClient;
const JsTodosApi = aClient.org.example.aclient.JsTodosApi
type Todo = aClient.org.example.aclient.Todo
const JsPostsApi = bClient.org.example.bclient.JsPostsApi
type Post = bClient.org.example.bclient.Post

function App() {
    const clientA = useMemo(() => createClientA("https://jsonplaceholder.typicode.com"), [])
    const clientB = useMemo(() => createClientB("https://jsonplaceholder.typicode.com"), [])
    const todoApi = useMemo(() => new JsTodosApi(clientA), [clientA])
    const postsApi = useMemo(() => new JsPostsApi(clientB), [clientB])

    const [post, setPost] = useState<Post | null>(null)
    const [todo, setTodo] = useState<Todo | null>(null)

    const loadPost = async () => {
        setPost(await postsApi.findById(1))
    }

    const loadTodo = async () => {
        setTodo(await todoApi.findById(1))
    }

    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <p>
                    Edit <code>src/App.tsx</code> and save to reload.
                </p>
                <h1>ToDo #1</h1>
                {todo && <p>{todo.toString()}</p>}
                {!todo && <button onClick={loadTodo}>Load ToDo</button>}
                <h1>Post #1</h1>
                {post && <p>{post.toString()}</p>}
                {!post && <button onClick={loadPost}>Load Post</button>}
                <a
                    className="App-link"
                    href="https://reactjs.org"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    Learn React
                </a>
            </header>
        </div>
    );
}

export default App;
