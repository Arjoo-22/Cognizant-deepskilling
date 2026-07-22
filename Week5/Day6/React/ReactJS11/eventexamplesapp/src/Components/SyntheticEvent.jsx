function SyntheticEvent() {

    function handleClick() {
        alert("I was clicked");
    }

    return (
        <button onClick={handleClick}>
            Click on me
        </button>
    );
}

export default SyntheticEvent;