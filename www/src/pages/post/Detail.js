import React, { useEffect } from 'react';
import { useState } from 'react';
import { Button } from 'react-bootstrap';

const Detail = (props) => {
  console.log('detail', props);
  const id = props.match.params.id;

  const [posts, setPosts] = useState({
    id: '',
    title: '',
    content: '',
    author: '',
  });

  useEffect(() => {
    fetch('http://localhost:8080/api/v1/posts/' + id)
      .then((res) => res.json())
      .then((res) => {
        setPosts(res);
      });
  }, []);

  // const deleteBook = () => {
  //   fetch('http://localhost:8080/posts/' + id, {
  //     method: 'DELETE',
  //   })
  //     .then((res) => res.text())
  //     .then((res) => {
  //       if (res === 'ok') {
  //         props.history.push('/');
  //       } else {
  //         alert('삭제실패');
  //       }
  //     });
  // };

  // const updateBook = () => {
  //   props.history.push('/updateForm/' + id);
  // };

  return (
    <div>
      <h1>책 상세보기</h1>
      {/* <Button variant="warning" onClick={updateBook}>
        수정
      </Button>
      {'  '}
      <Button variant="danger" onClick={deleteBook}>
        삭제
      </Button> */}
      <hr />
      <h1>{posts.title}</h1>
      <h3>{posts.author}</h3>
      <h1>{posts.content}</h1>
    </div>
  );
};

export default Detail;
