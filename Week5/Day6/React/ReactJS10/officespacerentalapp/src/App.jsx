function App() {

  const officeSpaces = [
    {
      Name: "DBS",
      Rent: 50000,
      Address: "Chennai"
    },
    {
      Name: "Regus",
      Rent: 75000,
      Address: "Bangalore"
    },
    {
      Name: "WeWork",
      Rent: 90000,
      Address: "Hyderabad"
    },
    {
      Name: "SmartWorks",
      Rent: 45000,
      Address: "Pune"
    }
  ];

  return (
    <div style={{ marginLeft: "80px" }}>

      <h1>Office Space , at Affordable Range</h1>

      {
        officeSpaces.map((office, index) => (

          <div key={index} style={{ marginBottom: "30px" }}>

            <img
              src="/office.jpg"
              alt="Office Space"
              width="250"
              height="200"
            />

            <h2>Name: {office.Name}</h2>

            <h3
              style={{
                color: office.Rent <= 60000 ? "red" : "green"
              }}
            >
              Rent Rs. {office.Rent}
            </h3>

            <h3>Address: {office.Address}</h3>

          </div>

        ))
      }

    </div>
  );
}

export default App;