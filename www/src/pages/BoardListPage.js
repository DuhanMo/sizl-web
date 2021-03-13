import React, { useEffect, useState } from "react";

const BoardListPage = () => {
  const [posts, setPosts] = useState("");
  useEffect(() => {
    fetch("/")
      .then((response) => response.text())
      .then((posts) => {
        setPosts(posts);
      });
  }, []);

  return (
    <div>
      <h1 className="App-title">{posts}</h1>

      <table className="table table-horizontal table-bordered">
        <thead class="thead-strong">
          <tr>
            <th>게시글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>최종수정일</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default BoardListPage;
