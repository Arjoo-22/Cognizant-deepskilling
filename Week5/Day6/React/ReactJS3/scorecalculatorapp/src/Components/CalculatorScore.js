import React from "react";
import "../Stylesheets/mystyle.css";

function CalculateScore(props) {
    const average = props.Total / props.goal;

    return (
        <div className="box">
            <h1>Student Score Calculator</h1>

            <h2>Name : {props.Name}</h2>

            <h2>School : {props.School}</h2>

            <h2>Total Score : {props.Total}</h2>

            <h2>Goal : {props.goal}</h2>

            <h2>Average Score : {average}</h2>
        </div>
    );
}

export default CalculateScore;