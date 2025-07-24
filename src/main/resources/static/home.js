const apicultor = JSON.parse(localStorage.getItem("apicultor"));

if (!apicultor) {
    // Se não estiver logado, volta pro login
    window.location.href = "login.html";
}

// Preenche dados básicos do apicultor
document.getElementById("nome").textContent = apicultor.nome;
document.getElementById("email").textContent = apicultor.email;
document.getElementById("colmeias").textContent = apicultor.quantidadeColmeias;
document.getElementById("mel").textContent = apicultor.quantidadeMel_kg;

// Inicializa valores padrão (pode atualizar depois)
document.getElementById("valorReceber").textContent = apicultor.valorReceber ? apicultor.valorReceber.toFixed(2) : "0.00";
document.getElementById("pago").textContent = apicultor.pago ? "Sim" : "Não";

function calcularServicos() {
    let servicos = "0"; // 0 = extração base
    document.querySelectorAll("input[type=checkbox]:checked").forEach(cb => {
        servicos += cb.value;
    });

    fetch(`/apicultor/servicos?nome=${encodeURIComponent(apicultor.nome)}&servicos=${servicos}`)
        .then(res => {
            if (!res.ok) throw new Error("Erro ao calcular");
            return res.json();
        })
        .then(data => {
            // Atualiza o valor na tela
            document.getElementById("valorReceber").textContent = data.valor.toFixed(2);
            document.getElementById("resultado").innerText = `🐝 Valor a receber pelos serviços: R$ ${data.valor.toFixed(2)}`;
        })
        .catch(err => {
            document.getElementById("resultado").innerText = `❌ ${err.message}`;
        });
}
