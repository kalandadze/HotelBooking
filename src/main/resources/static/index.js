var hotelId;
function closeModel1() {
    const modal = document.getElementById("modal1");
    modal.classList.remove('active');
    const overlay = document.getElementById('overlay1');
    overlay.classList.remove('active');
    clearOptions();
}
function openModel1() {
    const modal = document.getElementById("modal1");
    modal.classList.add('active');
    const overlay = document.getElementById('overlay1');
    overlay.classList.add('active');
}
function closeModel2() {
    const modal = document.getElementById("modal2");
    modal.classList.remove('active');
    const overlay = document.getElementById('overlay2');
    overlay.classList.remove('active');
}
function openModel2() {
    const modal = document.getElementById("modal2");
    modal.classList.add('active');
    const overlay = document.getElementById('overlay2');
    overlay.classList.add('active');
}

function addHotel(hotel) {
    // main div
    var div = document.createElement("div");
    div.className = "hotel";
    div.onclick = function () {
        bookingpanel(hotel);
    }

    // name
    var name = document.createElement("p");
    name.textContent = hotel.name;
    div.appendChild(name);

    //        child div
    // capacityInfo
    var div2 = document.createElement("div");
    div2.className = "capacityInfo";
    // current users
    var active = document.createElement("p");
    div2.appendChild(active);
    // max users
    var max = document.createElement("p");
    max.textContent = " / " + hotel.rooms.length;
    div2.appendChild(max);
    div.appendChild(div2);

    var div1 = document.getElementById("hotels");
    activeRooms(hotel, active);
    div1.appendChild(div);
}

function activeRooms(hotel, active) {
    var j = 0;
    for (var i = 0; i < hotel.rooms.length; i++) {
        if (hotel.rooms[i].booked) {
            j += 1;
        }
    }
    active.textContent = j;
}
async function setUp() {
    var url = "http://localhost:8080/hotels";
    var response = await fetch(url, { method: "GET" })
    const hotel = await response.json();
    console.log(hotel.hotelDtoList);
    for (var i = 0; i < hotel.hotelDtoList.length; i++) {
        console.log(hotel.hotelDtoList[i]);
        addHotel(hotel.hotelDtoList[i]);
    }
}
function clearOptions() {
    var rooms = document.getElementById("activeRooms");
    while (rooms.options.length > 1) {
        rooms.remove(rooms.options.length - 1);
    }
}
function addOptions(rooms) {
    var roomsSelect = document.getElementById("activeRooms");
    for (var i = 0; i < rooms.length; i++) {
        if (!rooms[i].booked) {
            var option = document.createElement("option");
            option.value = rooms[i].roomNum;
            option.textContent = rooms[i].roomNum;
            roomsSelect.appendChild(option);
        }
    }
}
function bookingpanel(hotel) {
    hotelId = hotel.rooms[0].hotel_id;
    addOptions(hotel.rooms);
    openModel1();
}
async function book() {
    var num = document.getElementById("activeRooms").value;
    url = "http://localhost:8080/rooms/" + num + "?hotelId=" + hotelId;
    console.log(url);
    await fetch(url, { method: "PUT" });
}
async function addNewHotel(){
    var name=document.getElementById("chatName").value;
    var num=document.getElementById("amount").value;
    await fetch("http://localhost:8080/hotels",{
        method:"POST",
        body:JSON.stringify({
            name:name,
            numOfRooms:num
        }),
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        }
    });
}