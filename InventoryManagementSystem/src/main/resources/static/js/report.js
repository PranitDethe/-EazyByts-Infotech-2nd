document.addEventListener('DOMContentLoaded', () => {
    fetchReport();
});

function fetchReport() {
    fetch('/api/reports/inventory')
        .then(response => response.json())
        .then(data => {
            const reportList = document.getElementById('report-list');
            reportList.innerHTML = '';
            data.forEach(product => {
                const reportItem = document.createElement('div');
                reportItem.className = 'report-item';
                reportItem.innerHTML = `
                    <h2>${product.name}</h2>
                    <p>Description: ${product.description}</p>
                    <p>Price: $${product.price}</p>
                    <p>Quantity: ${product.quantity}</p>
                    <p>Barcode: ${product.barcode}</p>
                `;
                reportList.appendChild(reportItem);
            });
        });
}
