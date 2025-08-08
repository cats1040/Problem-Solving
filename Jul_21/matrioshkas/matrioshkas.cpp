#include <iostream>
#include <bits/stdc++.h>

using namespace std;

void solve()
{
    int n;
    cin >> n;
    vector<int> a(n, 0);
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }

    stack<pair<int, int>> st; // value, sum

    for (int i = 0; i < n; i++)
    {
        if (st.empty())
        {
            if (a[i] > 0)
            {
                cout << ":-( Try again.\n";
                return;
            }

            st.push({a[i], 0});
        }
        else
        {
            if (a[i] > 0)
            {
                if (abs(st.top().first) == a[i])
                {
                    int sum = (a[i]);

                    if (st.top().second >= a[i])
                    {
                        cout << ":-( Try again.\n";
                        return;
                    }

                    st.pop();

                    if (!st.empty())
                    {
                        pair<int, int> temp = st.top();
                        temp.second += sum;

                        if (sum >= abs(st.top().first))
                        {
                            cout << ":-( Try again.\n";
                            return;
                        }

                        st.pop();
                        st.push(temp);
                    }
                }
                else
                {
                    cout << ":-( Try again.\n";
                    return;
                }
            }
            else
            {
                if (abs(st.top().first) <= abs(a[i]))
                {
                    cout << ":-( Try again.\n";
                    return;
                }

                st.push({a[i], 0});
            }
        }
    }

    if (!st.empty())
    {
        cout << ":-( Try again.\n";
        return;
    }

    cout << ":-) Matrioshka!\n";
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);

    int t;
    cin >> t;

    while (t--)
    {
        solve();
    }

    return 0;
}