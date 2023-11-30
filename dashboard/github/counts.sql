select max(stargazers_count) as star_num_max,
       avg(stargazers_count) as ave_num_avg,
       percentile_cont(0.5) within group(order by stargazers_count) as star_num_median,
       percentile_cont(0.9) within group(order by stargazers_count) as star_num_90,
       percentile_cont(0.6) within group(order by stargazers_count) as star_num_60,
       percentile_cont(0.4) within group(order by stargazers_count) as star_num_40,
       percentile_cont(0.2) within group(order by stargazers_count) as star_num_20
from collectors.github_starred_repo;