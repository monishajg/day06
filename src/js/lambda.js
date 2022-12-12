const = hello = function(name) {
    console.info('Hello ${name}')
}
const username = 'fred'
const hi = hello
const names = ['fred', 'betty', 'barney', 'Wilma']

const sayHello = function(fn, args) {
    // if fn is a function, then I can call the function
    fn(args)
}

console.info('>>>hello:', hello)
hello(username)
hi('barney') // call directly

sayHello(helllo, 'Wilma') //using one function to call another

console.info('Sat hello to these guys', names)
for (let n of names)
    sayHello(hello, n)

sayHello(power, 5)

// functional type accepts function, instead of scalar variable