let triangleTwo = (size) => {
    let line = 1,space = size, ans = "";
    while(line <= size && space >= 0){
        ans += (" ".repeat(space));
        ans += ("*".repeat(line));
        console.log(ans)
        line++;
        space--;
    }
}

triangleTwo(5);