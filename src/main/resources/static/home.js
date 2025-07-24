const apicultor = JSON.parse(localStorage.getItem("apicultor"));

if (!apicultor) {
    window.location.href = "login.html";
}

document.getElementById("nome").textContent = apicultor.nome;
document.getElementById("email").textContent = apicultor.email;
document.getElementById("colmeias").textContent = apicultor.quantidadeColmeias;
document.getElementById("mel").textContent = apicultor.quantidadeMel_kg;

function calcularServicos() {
    let servicos = "0"; // 0 = apenas extração
    document.querySelectorAll("input[type=checkbox]:checked").forEach(cb => {
        servicos += cb.value;
    });

    fetch(`/apicultor/servicos?nome=${apicultor.nome}&servicos=${servicos}`)
        .then(res => {
            if (!res.ok) throw new Error("Erro ao calcular");
            return res.json();
        })
        .then(data => {
            document.getElementById("resultado").innerText = `Valor a receber: R$ ${data.valor.toFixed(2)}`;
        })
        .catch(err => {
            document.getElementById("resultado").innerText = err.message;
        });
}
