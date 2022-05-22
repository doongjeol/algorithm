function solution(N, road, K) {
    var answer = 0;
    let graph = makeArray(N,road);
    graph[1][1] = 0;
    console.log(graph)
    let visited = new Array(N + 1);
    dfs(graph,1, visited, K,0);
    return answer;
}

function dfs(graph, cur, visited, K, curDistance){
    // 현재 마을 방문 처리
    visited[cur] = true;
    // console.log(graph.length);

    for (let i = 1; i < graph.length; i++) {
        // console.log(cur,i,graph[cur][i]);
        if(graph[cur][i] > 0 && !visited[i] && curDistance <= K ){
            dfs(graph, i, visited, curDistance + graph[cur][i]);
        }
    }
}

function makeArray(N, road){
    // 2차원 배열 만들기
    let graph = new Array(N+1);
    for (let i = 0; i < N+1 ; i++) {
        graph[i] = new Array(1);
    }

    console.log(graph)
    // 인접 행렬 만들기
    for (let i = 0; i <N ; i++) {
        let a = road[i][0];
        let b = road[i][1];
        let c = road[i][2];
        graph[a][b] = c;
    }

    console.log(graph[1][2])
    console.log(graph[2][3])
    console.log(graph[5][2])
    console.log(graph[1][4])
    console.log(graph[5][3])
    console.log(graph[5][4])
    return graph;
}

solution(5, [[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]], 3)
// solution(6, [[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]], 4)
