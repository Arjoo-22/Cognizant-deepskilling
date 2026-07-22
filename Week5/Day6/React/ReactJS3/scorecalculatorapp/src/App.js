import React from "react";
import CalculateScore from "./Components/CalculateScore";

function App() {
    return (
        <div>
            <CalculateScore
                Name="Shourya Gupta"
                School="GLA University"
                Total={480}
                goal={6}
            />
        </div>
    );
}

export default App;