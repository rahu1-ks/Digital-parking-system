const API_BASE_URL = "http://localhost:8080/parking";

// Show Park Form
function showParkForm() {
    document.getElementById("parkFormContainer").style.display = "block";
    document.getElementById("unparkFormContainer").style.display = "none";
	document.getElementById("showParkFormButton").style.display = "none";
	document.getElementById("showUnparkFormButton").style.display = "block";
}

// Show Unpark Form
function showUnparkForm() {
    document.getElementById("parkFormContainer").style.display = "none";
    document.getElementById("unparkFormContainer").style.display = "block";
	document.getElementById("showParkFormButton").style.display = "block";
	document.getElementById("showUnparkFormButton").style.display = "none";
}

// Handle Park Form

/*async function parkVehicle() {
    const vehicleNumber = document.getElementById("vehicleNumber").value;
    const vehicleType = document.getElementById("vehicleType").value;

    const response = await fetch(`${API_BASE_URL}/park`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ vehicleNumber, vehicleType })
    });

    if (response.ok) {
        const data = await response.json();
        document.getElementById("parkResult").innerText =`Vehicle parked.<br>Ticket ID: ${data.ticketId}.<br>Spot ID: ${data.spotId}.<br>Entry time: ${data.entryTime}`;
    } else {
        document.getElementById("parkResult").innerText =
            "Error parking vehicle.";
    }
}*/

document.getElementById("parkForm").addEventListener("submit", async function(e) {
    e.preventDefault();
    const vehicleNumber = document.getElementById("vehicleNumber").value;
    const vehicleType = document.getElementById("vehicleType").value;

    const response = await fetch(`${API_BASE_URL}/park`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ vehicleNumber, vehicleType })
    });

    if (response.ok) {
        const data = await response.json();
        alert(`Vehicle parked.\nTicket ID: ${data.ticketId}.\nSpot ID: ${data.spotId}.\nEntry time: ${data.entryTime}`);
    } else {
        alert("Error parking vehicle.");
    }
});

// Handle Unpark Form
document.getElementById("unparkForm").addEventListener("submit", async function(e) {
    e.preventDefault();
    const ticketId = document.getElementById("ticketId").value;

    const response = await fetch(`${API_BASE_URL}/unpark/${ticketId}`, {
        method: "GET"
    });

    if (response.ok) {
        const data = await response.json();
		alert(`Vehicle unparked.\nVehicle number: ${data.vehicleNumber}.\nVehicle type: ${data.vehicleType}\nSpot ID: ${data.spotId}.\nEntry time: ${data.entryTime}.\nExit time: ${data.exitTime}.\nTotal fee: ${data.totalFee}.`);
    } else {
        alert("Error unparking vehicle.");
    }
});
