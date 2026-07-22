import Counter from "./Components/Counter";
import SayWelcome from "./Components/SayWelcome";
import SyntheticEvent from "./Components/SyntheticEvent";
import CurrencyConvertor from "./Components/CurrencyConvertor";

function App() {
  return (
    <div style={{ margin: "30px" }}>
      <Counter />
      <br />

      <SayWelcome />
      <br />

      <SyntheticEvent />
      <br />

      <CurrencyConvertor />
    </div>
  );
}

export default App;