//https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

#include<bits/stdc++.h>
using namespace std;
class Graph
{
    int V;
    list<int> *adj;
public :
    Graph(int V);
    void addEdge(int v,int w);
    bool isCyclic();
};
Graph::Graph(int V)
{
    this->V = V;
    adj = new list<int>[V];
}
void Graph::addEdge(int v,int w)
{
    adj[v].push_back(w);
}
int main()
{
    int T;
    cin>>T;
    while(T--)
    {
        int _size,N;
        cin>>_size>>N;
        Graph *g = new Graph(_size);
        for(int i=0;i<N;i++)
        {
            int u,v;
            cin>>u>>v;
            g->addEdge(u,v);
        }
        cout<<g->isCyclic()<<endl;
    }
}

bool dfs(int s, list<int> adj[], int vis[])
{
    vis[s] = 1;
    bool f = true;
    for(auto it:adj[s])
    {
        if(vis[it] == 1)
            return false;
        else if(vis[it] == 2)
            continue;
        f &= dfs(it, adj, vis);
    }
    
    vis[s] = 2;
    /*if(f)
        printf("1\n");
    else
    	printf("2\n");*/
    return f;
}

bool Graph :: isCyclic()
{
    int i, vis[V];
    bool flag = true;
    for(i = 0 ; i < V ; i++)
        vis[i] = 0;
    for(i = 0 ; i < V ; i++)
    {
        if(!vis[i])
        {
            flag &= dfs(i, adj, vis);
        }
    }
    return !flag;
}