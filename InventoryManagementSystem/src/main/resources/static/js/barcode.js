document.getElementById('barcode-file').addEventListener('change', event => {
    const file = event.target.files[0];
    if (file) {
        const formData = new FormData();
        formData.append('file', file);

        fetch('/api/barcode/scan', {
            method: 'POST',
            body: formData,
        })
        .then(response => response.json())
        .then(data => {
            const resultDiv = document.getElementById('barcode-scan-result');
            resultDiv.innerHTML = `Scanned Barcode: ${data.barcode}`;
        });
    }
});
