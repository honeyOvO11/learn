# Learn - 学习代码仓库

个人学习过程中编写的所有代码、课程作业和项目作品汇总。

## 目录结构

```
learn/
├── languages/              # 编程语言学习
│   ├── cpp/               # C/C++ 语言学习代码与实验
│   ├── java/              # Java 语言学习代码
│   └── git-learning/      # Git 版本控制学习
├── courses/                # 专业课程作业与实验报告
│   ├── java-homework/     # Java 课程作业
│   ├── computer-organization/  # 计算机组成原理
│   ├── algorithm/         # 算法设计与分析
│   ├── networking/        # 计算机网络
│   ├── mysql-exercise/    # MySQL 数据库练习
│   ├── frontend-final/    # 前端开发技术期末项目
│   └── math-modeling/     # 数学建模
├── projects/               # 项目作品
│   ├── gugugaga-run/      # gugugaga快跑 游戏项目
│   ├── minigame/          # 小游戏
│   └── portfolio/         # 个人作品集网站
├── .gitignore
└── README.md
```

## 内容概览

| 分类 | 目录 | 主要内容 |
|------|------|----------|
| 编程语言 | `languages/cpp` | C++ 基础语法、数组、指针、函数等练习 |
| 编程语言 | `languages/java` | Java 基础、面向对象、集合、多线程等 |
| 工具 | `languages/git-learning` | Git 常用命令练习 |
| 课程 | `courses/algorithm` | 蛮力法、分治法、贪心法、最小生成树等算法实验 |
| 课程 | `courses/networking` | VLAN 配置、静态路由、网络基础配置实验 |
| 课程 | `courses/computer-organization` | 计算机组成原理实验 |
| 课程 | `courses/mysql-exercise` | MySQL 数据库 SQL 练习 |
| 课程 | `courses/frontend-final` | 前端开发技术期末考核 |
| 课程 | `courses/math-modeling` | 数学建模竞赛作品 |
| 项目 | `projects/gugugaga-run` | HTML5 跑酷游戏 |
| 项目 | `projects/portfolio` | 个人作品集网页 |

## 关于本仓库

- 所有代码均为学习过程中编写，仅供参考
- 编译产物（`.exe`、`.class` 等）和软件安装目录已通过 `.gitignore` 排除
- 课程实验报告（Word/PDF）随代码一并保留，便于复习

## 仓库维护指南

### 日常添加新代码

```bash
# 1. 进入仓库目录
cd D:\tangOvO1\learn

# 2. 把新文件放到对应分类目录下
#    - 语言学代码 → languages/
#    - 课程作业 → courses/
#    - 完整项目 → projects/

# 3. 查看改动
git status

# 4. 添加并提交
git add .
git commit -m "添加: xxx课程作业 / xxx项目"

# 5. 推送到 GitHub
git push
```

### 分类原则

| 新内容类型 | 放入目录 | 示例 |
|-----------|---------|------|
| 新语言学习代码 | `languages/语言名/` | `languages/python/` |
| 新课程作业 | `courses/课程英文名/` | `courses/operating-system/` |
| 新项目作品 | `projects/项目名/` | `projects/todo-app/` |
| 工具学习 | `languages/工具名-learning/` | `languages/docker-learning/` |

### 提交信息规范

- `添加: xxx` — 新增文件/功能
- `修改: xxx` — 修改已有内容
- `整理: xxx` — 重构、移动文件、清理
- `修复: xxx` — 修复 bug 或错误

### 注意事项

1. **不要提交编译产物**：`.exe`、`.class`、`.pyc`、`node_modules/` 等已被 `.gitignore` 自动排除
2. **不要提交大文件**：视频、安装包、数据库文件（`.ibd`、`.pem`）等不要放入仓库
3. **定期推送**：写完一批代码就 commit + push，避免本地丢失
4. **保持目录整洁**：新代码按分类放入对应目录，不要直接堆在根目录
5. **敏感信息**：代码中不要包含密码、密钥、个人隐私信息
