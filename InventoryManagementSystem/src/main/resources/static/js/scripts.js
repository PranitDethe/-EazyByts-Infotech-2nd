// scripts.js

// Function to save a new or existing product
async function saveProduct(event) {
    event.preventDefault();
    const id = document.getElementById('product-id').value || '';
    const name = document.getElementById('product-name').value;
    const description = document.getElementById('product-description').value;
    const price = document.getElementById('product-price').value;
    const quantity = document.getElementById('product-quantity').value;

    const product = { name, description, price, quantity };

    try {
        let response;
        if (id) {
            // Update existing product
            response = await fetch(`/api/products/${id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(product),
            });
        } else {
            // Add new product
            response = await fetch('/api/products', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(product),
            });
        }

        if (!response.ok) {
            const errorText = await response.text();
            throw new Error(`Error: ${response.status} - ${errorText}`);
        }

        const result = await response.json();
        console.log('Product saved:', result);
        populateProductList();
        hideProductForm();
    } catch (error) {
        console.error('Error saving product:', error);
    }
}

// Populate products list
async function populateProductList() {
    try {
        const response = await fetch('/api/products');
        if (!response.ok) {
            const errorText = await response.text();
            throw new Error(`Error: ${response.status} - ${errorText}`);
        }

        const products = await response.json();
        const productList = document.getElementById('product-list');
        productList.innerHTML = '';
        products.forEach(product => {
            const row = `<tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.quantity}</td>
                <td>
                    <button class="btn btn-warning btn-sm" onclick="editProduct(${product.id})">Edit</button>
                    <button class="btn btn-danger btn-sm" onclick="deleteProduct(${product.id})">Delete</button>
                </td>
            </tr>`;
            productList.innerHTML += row;
        });
    } catch (error) {
        console.error('Error fetching products:', error);
    }
}

// Function to edit a product
async function editProduct(id) {
    try {
        const response = await fetch(`/api/products/${id}`);
        if (!response.ok) {
            const errorText = await response.text();
            throw new Error(`Error: ${response.status} - ${errorText}`);
        }

        const product = await response.json();
        document.getElementById('product-id').value = product.id;
        document.getElementById('product-name').value = product.name;
        document.getElementById('product-description').value = product.description;
        document.getElementById('product-price').value = product.price;
        document.getElementById('product-quantity').value = product.quantity;
        document.getElementById('form-title').textContent = 'Edit Product';
        document.getElementById('product-form').style.display = 'block';
    } catch (error) {
        console.error('Error fetching product:', error);
    }
}

// Function to delete a product
async function deleteProduct(id) {
    try {
        const response = await fetch(`/api/products/${id}`, {
            method: 'DELETE',
        });

        if (!response.ok) {
            const errorText = await response.text();
            throw new Error(`Error: ${response.status} - ${errorText}`);
        }

        populateProductList();
    } catch (error) {
        console.error('Error deleting product:', error);
    }
}

// Function to create shipping
async function createShipping(event) {
    event.preventDefault();
    const address = document.getElementById('address').value;
    const weight = document.getElementById('weight').value;

    try {
        const response = await fetch('/api/shipping', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ address, weight }),
        });

        if (!response.ok) {
            const errorText = await response.text();
            throw new Error(`Error: ${response.status} - ${errorText}`);
        }

        const result = await response.json();
        document.getElementById('shipping-message').textContent = `Shipping created: ${result.trackingNumber}`;
    } catch (error) {
        console.error('Error creating shipping:', error);
        document.getElementById('shipping-message').textContent = `Error: ${error.message}`;
    }
}

// Function to show product form
function showProductForm() {
    document.getElementById('product-id').value = '';
    document.getElementById('product-name').value = '';
    document.getElementById('product-description').value = '';
    document.getElementById('product-price').value = '';
    document.getElementById('product-quantity').value = '';
    document.getElementById('form-title').textContent = 'Add Product';
    document.getElementById('product-form').style.display = 'block';
}

// Function to hide product form
function hideProductForm() {
    document.getElementById('product-form').style.display = 'none';
}

// Initialize page
populateProductList();
populateInventoryReport();
