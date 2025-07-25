function login() {
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;

    fetch(`/apicultor/login?email=${email}&senha=${senha}`)
        .then(res => {
            if (!res.ok) throw new Error("Login inválido");
            return res.json();
        })
        .then(data => {
            // Salva no localStorage para usar na home
            localStorage.setItem("apicultor", JSON.stringify(data));
            window.location.href = "home.html";
        })
        .catch(err => {
            document.getElementById("erro").innerText = err.message;
        });
}
