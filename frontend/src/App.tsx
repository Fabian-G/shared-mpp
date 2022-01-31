import React, {useMemo, useState} from 'react';
import logo from './logo.svg';
import './App.css';
import metaClient from "meta-client"

const createClient = metaClient.org.example.commonclient.createClient;
const JsTodosApi = metaClient.org.example.aclient.JsTodosApi
type Todo = metaClient.org.example.aclient.Todo
const JsPostsApi = metaClient.org.example.bclient.JsPostsApi
type Post = metaClient.org.example.bclient.Post

function App() {
    const client = useMemo(() => createClient("https://jsonplaceholder.typicode.com"), [])
    const todoApi = useMemo(() => new JsTodosApi(client), [client])
    const postsApi = useMemo(() => new JsPostsApi(client), [client])

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
