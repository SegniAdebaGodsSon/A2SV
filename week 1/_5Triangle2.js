let triangleTwo = (size) => {
    let line = 1,space = size-1;
    for(let i = 1; line <= size; i+=2, line++, space--){
        console.log(" ".repeat(space).concat("*".repeat(i)));
    }
}
triangleTwo(6);