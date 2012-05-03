function map(){
    emit(this.id,{price:this.price}); 
} 
function reduce(key,value){
    var sum = 0;
    for ( var i=0; i<value.length; i++ ) {

            sum += value[i].price;
    }
    return sum;
}