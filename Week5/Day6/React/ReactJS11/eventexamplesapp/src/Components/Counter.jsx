import { useState } from "react";

function Counter() {

    const [count, setCount] = useState(0);

    function increment() {
        setCount(count + 1);
    }

    function decrement() {
        setCount(count - 1);
    }

    function sayHello() {
        alert("Hello!!");
    }

    function handleIncrement() {
        increment();
        sayHello();
    }

    return (
        <div>

            <h2>{count}</h2>

            <button onClick={handleIncrement}>
                Increment
            </button>

            <br /><br />

            <button onClick={decrement}>
                Decrement
            </button>

        </div>
    );
}

export default Counter;