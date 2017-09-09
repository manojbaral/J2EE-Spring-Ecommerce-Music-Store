/**
 * Created by Manoj Baral on 2/25/2017.
 */

//Rest API to handle functionality

var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http){

    $scope.refreshCart = function () {
        $http.get('/eMusicStore/rest/cart/'+$scope.cartId).success(function (data) {
            $scope.cart=data;
        });
    };

    //Rest Service clear cart
    $scope.clearCart = function () {
        $http.delete('/eMusicStore/rest/cart/'+$scope.cartId).success($scope.refreshCart());
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    //Rest Service for add cart
    $scope.addToCart = function (productId) {
        $http.put('/eMusicStore/rest/cart/add/'+productId).success(function () {
            //$scope.refreshCart($http.get('/eMusicStore/rest/cart/cartId'));
            alert("Product successfully added to the cart!")
        });
    };

    //Rest Service for removecart
    $scope.removeFromCart = function (productId) {
        $http.put('/eMusicStore/rest/cart/remove/'+productId).success(function (data) {
            $scope.refreshCart();
        });
    };

    //Rest Service for Grandtotal
    $scope.calGrandTotal = function() {
        var grandTotal=0;

        for (var i=0; i<$scope.cart.cartItems.length; i++) {
            grandTotal +=$scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;

    }
});
