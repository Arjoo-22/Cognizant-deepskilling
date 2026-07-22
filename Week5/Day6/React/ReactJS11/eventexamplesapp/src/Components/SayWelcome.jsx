function SayWelcome() {

    function welcome(message) {
        alert(message);
    }

    return (
        <button onClick={() => welcome("Welcome")}>
            Say Welcome
        </button>
    );
}

export default SayWelcome;