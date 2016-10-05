Places an order

## Testing
curl -H "Content-Type: application/json" --data "{\"idsProducts\":[1,2,3],\"idCustomer\":5}" http://localhost:8000/checkout-service/checkout/placeorder